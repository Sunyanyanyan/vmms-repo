package com.zckj.sys.utils;

import com.zckj.sys.entity.Worker;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * jwt工具类
 */
public class JwtUtils {


    public static final String SUBJECT = "zckj";

    //秘钥
    public static final String APPSECRET = "zckj233";

    public static final long EXPIRE = 1000 * 60 * 30;  //过期时间，毫秒，30分钟


    /**
     * 生成jwt token
     *
     * @param worker
     * @return
     */
    public static String geneJsonWebToken(Worker worker) {

        if (worker == null || StringUtils.isEmpty(worker.getWorkerid())
                || StringUtils.isEmpty(worker.getWorkername())) {
            return null;
        }
        String token = Jwts.builder()
                .setSubject(SUBJECT)

                .claim("workerid", worker.getWorkerid()) // 设置token主体部分，存储用户信息
                .claim("workername", worker.getWorkername())

                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();

        return token;
    }


    /**
     * 校验jwt token
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
        return claims;
    }

    //测试生成jwt token
    private static String testGeneJwt(){
        Worker member = new Worker();
        member.setWorkerid("5111");
        member.setWorkername("Helen");

        String token = JwtUtils.geneJsonWebToken(member);
        System.out.println(token);
        return token;
    }

    //测试校验jwt token
    private static void testCheck(String token){

        Claims claims = JwtUtils.checkJWT(token);
        String workerid = (String)claims.get("workerid");
        String workername = (String)claims.get("workername");
        System.out.println(workerid);
        System.out.println(workername);
    }

    /**
     * 根据token字符串获取操作员id
     * @param request
     * @return
     */
    public static String getWorkerIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        System.out.println("==getWorkerIdByJwtToken===" + jwtToken);
        if (StringUtils.isEmpty(jwtToken)) {
            return "";
        }
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(jwtToken);
            Claims claims = claimsJws.getBody();

        return (String) claims.get("workerid");
    }

    public static void main(String[] args){
        String token = testGeneJwt();
        testCheck(token);
    }
}
