package com.zckj.sys.controller;

import com.zckj.sys.common.R;
import com.zckj.sys.entity.Org;
import com.zckj.sys.entity.Role;
import com.zckj.sys.entity.Type;
import com.zckj.sys.entity.Worker;
import com.zckj.sys.service.OrgService;
import com.zckj.sys.service.RoleService;
import com.zckj.sys.service.TypeService;
import com.zckj.sys.service.WorkerService;
import com.zckj.sys.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sys/user")
@CrossOrigin  //解决跨域
@Slf4j
public class LoginController {
    //login
//    @PostMapping("login")
//    public R login() {
//        return R.ok().data("token", "admin");
//    }

    @Autowired
    private WorkerService workerService;

    @Autowired
    private OrgService orgService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private RoleService roleService;

    /**
     * 系统登录验证
     */
    @PostMapping("login")
    public R login(@RequestBody Worker worker, HttpServletRequest request) {
        String id = request.getSession().getId();
        System.out.println("--------login-----------" + id);
        // worker对象封装用户名和密码
        // 调用service方法实现登录
        // 返回token值， 使用jwt生成
        String username = worker.getCode();
        String password = worker.getPwd();
        System.out.println(username);
        System.out.println(password);
        String token = workerService.login(worker);

        return R.ok().data("token", token);
    }

    /**
     * 根据token获取用户信息
     */
    @GetMapping("info")
    public R getWorkerInfo(HttpServletRequest request) {
        System.out.println("request============" + request);
        // 调用jwt工具类的方法。根据request对象获取头信息，返回用户id
        String workerIdByJwtToken = JwtUtils.getWorkerIdByJwtToken(request);
        // 查询数据库，根据操作员id获取操作员信息
        System.out.println(workerIdByJwtToken);
        Worker worker = workerService.getByWorkerId(workerIdByJwtToken);

        // 操作员所在单位信息
        Org org = orgService.getOrg(worker.getOrgno());

        //
        List<Org> orgList = orgService.selectOrg(worker.getOrgno());
//        List<Type> type = typeService.getType(worker.getOrgno(),"授权");

//        if (type.size() != 0) {
//            String validTime = "";
//            for (Type t : type) {
//                validTime = t.getNote();
//            }
//        }

        /* 操作员岗位信息 */
//        String[] role = worker.getRoleid().split(",");
//        ArrayList<Role> list = new ArrayList<>();
//        for (int i = 0; i < role.length; i++) {
//            Role r = new Role();
//            r.setRoleid(role[i]);
//            r.setGrade(org.getGrade());
//            List<Role> roleList = roleService.getRole(r);
//            if (roleList.size() > 0) {
//                r = roleList.get(0);
//                list.add(r);
//            }
//        }
//        return R.ok().data("worker", worker).data("org",org).data("orgList", orgList).data("roles", list);
        return R.ok().data("worker", worker);
    }

    //info
//    @GetMapping("info")
//    public R info() {
//        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//    }

    @PostMapping("logout")
    public R logout() {

        return R.ok().data("token", "[null]");
    }


}


