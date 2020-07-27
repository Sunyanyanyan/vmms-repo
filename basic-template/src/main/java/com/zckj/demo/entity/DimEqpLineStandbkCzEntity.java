package com.zckj.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ${comments}
 * 
 * @author sunyan
 * @email syan_2019@163.com
 * @date 2020-06-10 20:14:07
 */
@Data
@TableName("DIM_EQP_LINE_STANDBK_CZ")
public class DimEqpLineStandbkCzEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private String linePkId;
	/**
	 * $column.comments
	 */
	private String eqpNo;
	/**
	 * $column.comments
	 */
	private String nmplateLibId;
	/**
	 * $column.comments
	 */
	private String lineNm;
	/**
	 * $column.comments
	 */
	private String runNo;
	/**
	 * $column.comments
	 */
	private String gisElecStatNo;
	/**
	 * $column.comments
	 */
	private String gisElecStatNm;
	/**
	 * $column.comments
	 */
	private String voltLvl;
	/**
	 * $column.comments
	 */
	private String voltLvlDsc;
	/**
	 * $column.comments
	 */
	private String blgCity;
	/**
	 * $column.comments
	 */
	private String maintOrg;
	/**
	 * $column.comments
	 */
	private String maintOrgNm;
	/**
	 * $column.comments
	 */
	private String blgSch;
	/**
	 * $column.comments
	 */
	private String blgSchDsc;
	/**
	 * $column.comments
	 */
	private String schOrg;
	/**
	 * $column.comments
	 */
	private String maintTeam;
	/**
	 * $column.comments
	 */
	private String runStCd;
	/**
	 * $column.comments
	 */
	private String runStDsc;
	/**
	 * $column.comments
	 */
	private String startElecStat;
	/**
	 * $column.comments
	 */
	private String endElecStat;
	/**
	 * $column.comments
	 */
	private String startTyp;
	/**
	 * $column.comments
	 */
	private String startTypDsc;
	/**
	 * $column.comments
	 */
	private String endTyp;
	/**
	 * $column.comments
	 */
	private String endTypDsc;
	/**
	 * $column.comments
	 */
	private String startPos;
	/**
	 * $column.comments
	 */
	private String endPos;
	/**
	 * $column.comments
	 */
	private String shipDt;
	/**
	 * $column.comments
	 */
	private String erectMode;
	/**
	 * $column.comments
	 */
	private String erectModeDsc;
	/**
	 * $column.comments
	 */
	private String lineNatureCd;
	/**
	 * $column.comments
	 */
	private String lineNatureDsc;
	/**
	 * $column.comments
	 */
	private String repmaintFlg;
	/**
	 * $column.comments
	 */
	private String lineLen;
	/**
	 * $column.comments
	 */
	private String overhdLineLen;
	/**
	 * $column.comments
	 */
	private String cableLineLen;
	/**
	 * $column.comments
	 */
	private String overhdWiringMode;
	/**
	 * $column.comments
	 */
	private String overhdWiringModeDsc;
	/**
	 * $column.comments
	 */
	private String cableWiringMode;
	/**
	 * $column.comments
	 */
	private String cableWiringModeDsc;
	/**
	 * $column.comments
	 */
	private String lineColorScaleCd;
	/**
	 * $column.comments
	 */
	private String lineColorScaleDsc;
	/**
	 * $column.comments
	 */
	private String constUnit;
	/**
	 * $column.comments
	 */
	private String inspectOrg;
	/**
	 * $column.comments
	 */
	private String asstNature;
	/**
	 * $column.comments
	 */
	private String asstNatureDsc;
	/**
	 * $column.comments
	 */
	private String asstOrg;
	/**
	 * $column.comments
	 */
	private String asstNo;
	/**
	 * $column.comments
	 */
	private String eqpAddMode;
	/**
	 * $column.comments
	 */
	private String eqpAddModeDsc;
	/**
	 * $column.comments
	 */
	private String impDegreeCd;
	/**
	 * $column.comments
	 */
	private String impDegreeDsc;
	/**
	 * $column.comments
	 */
	private String spanAreaTyp;
	/**
	 * $column.comments
	 */
	private String spanAreaTypDsc;
	/**
	 * $column.comments
	 */
	private String designVoltLvl;
	/**
	 * $column.comments
	 */
	private String designVoltLvlDsc;
	/**
	 * $column.comments
	 */
	private String groundPoleFlg;
	/**
	 * $column.comments
	 */
	private String startSwitNo;
	/**
	 * $column.comments
	 */
	private String endSwitNo;
	/**
	 * $column.comments
	 */
	private String maxAllowElec;
	/**
	 * $column.comments
	 */
	private String economyElec;
	/**
	 * $column.comments
	 */
	private String runLoad;
	/**
	 * $column.comments
	 */
	private String ratedConveyPw;
	/**
	 * $column.comments
	 */
	private String designOrg;
	/**
	 * $column.comments
	 */
	private String buildOrg;
	/**
	 * $column.comments
	 */
	private String remark;
	/**
	 * $column.comments
	 */
	private String registTm;
	/**
	 * $column.comments
	 */
	private String eqpMaster;
	/**
	 * $column.comments
	 */
	private String wbsNo;
	/**
	 * $column.comments
	 */
	private String wbsDsc;
	/**
	 * $column.comments
	 */
	private String blgMainlineCd;
	/**
	 * $column.comments
	 */
	private String asstOrgNm;
	/**
	 * $column.comments
	 */
	private String blgCityNm;
	/**
	 * $column.comments
	 */
	private String maintTeamNm;
	/**
	 * $column.comments
	 */
	private String eqpMasterNm;
	/**
	 * $column.comments
	 */
	private String schOrgNm;
	/**
	 * $column.comments
	 */
	private String startPosNm;
	/**
	 * $column.comments
	 */
	private String endPosNm;
	/**
	 * $column.comments
	 */
	private String updtFlg;
	/**
	 * $column.comments
	 */
	private String termLineFlg;
	/**
	 * $column.comments
	 */
	private String provdGroundLineFlg;
	/**
	 * $column.comments
	 */
	private String tryClosOvhaulFlg;
	/**
	 * $column.comments
	 */
	private String zeroSequeCapacit;
	/**
	 * $column.comments
	 */
	private String normSequeCapacit;
	/**
	 * $column.comments
	 */
	private String normSequeResist;
	/**
	 * $column.comments
	 */
	private String normSequeReact;
	/**
	 * $column.comments
	 */
	private String normSequeSuscept;
	/**
	 * $column.comments
	 */
	private String normSequeConduct;
	/**
	 * $column.comments
	 */
	private String zeroSequeResist;
	/**
	 * $column.comments
	 */
	private String zeroSequeReact;
	/**
	 * $column.comments
	 */
	private String zeroSequeSuscept;
	/**
	 * $column.comments
	 */
	private String zeroSequeConduct;
	/**
	 * $column.comments
	 */
	private String transmutaId;
	/**
	 * $column.comments
	 */
	private String transmutaIdDsc;
	/**
	 * $column.comments
	 */
	private String farmnetFlg;
	/**
	 * $column.comments
	 */
	private String stdRowFlg;
	/**
	 * $column.comments
	 */
	private String regionFeatCd;
	/**
	 * $column.comments
	 */
	private String regionFeatDsc;
	/**
	 * $column.comments
	 */
	private String spelineId;
	/**
	 * $column.comments
	 */
	private String releaseSt;
	/**
	 * $column.comments
	 */
	private String blgFeederCd;
	/**
	 * $column.comments
	 */
	private String blgFeederNm;
	/**
	 * $column.comments
	 */
	private String majorTypCd;
	/**
	 * $column.comments
	 */
	private String majorTypDsc;
	/**
	 * $column.comments
	 */
	private String mdfAfterEqpNm;
	/**
	 * $column.comments
	 */
	private String runFlg;
	/**
	 * $column.comments
	 */
	private String runEnviron;
	/**
	 * $column.comments
	 */
	private String feedAreaCd;
	/**
	 * $column.comments
	 */
	private String feedAreaNm;
	/**
	 * $column.comments
	 */
	private String reltFeederId;
	/**
	 * $column.comments
	 */
	private String phyObjId;
	/**
	 * $column.comments
	 */
	private String matchStCd;
	/**
	 * $column.comments
	 */
	private String matchStDsc;
	/**
	 * $column.comments
	 */
	private String printFlg;
	/**
	 * $column.comments
	 */
	private Integer towerNum;
	/**
	 * $column.comments
	 */
	private Integer section;
	/**
	 * $column.comments
	 */
	private String cmsLineId;
	/**
	 * $column.comments
	 */
	private String lineVolt;
	/**
	 * $column.comments
	 */
	private String wireSpec;
	/**
	 * $column.comments
	 */
	private Integer wireLen;
	/**
	 * $column.comments
	 */
	private String lossyLosslessFlg;
	/**
	 * $column.comments
	 */
	private String farmnetTyp;
	/**
	 * $column.comments
	 */
	private String lineSt;
	/**
	 * $column.comments
	 */
	private String llComputeModeCd;
	/**
	 * $column.comments
	 */
	private Integer llComputeAp;
	/**
	 * $column.comments
	 */
	private Integer llComputeRp;
	/**
	 * $column.comments
	 */
	private Integer lineResist;
	/**
	 * $column.comments
	 */
	private Integer lineReact;
	/**
	 * $column.comments
	 */
	private String publineSpelineId;
	/**
	 * $column.comments
	 */
	private String transTypNo;
	/**
	 * $column.comments
	 */
	private String blgTrans;
	/**
	 * $column.comments
	 */
	private String lowvoltLineFlg;
	/**
	 * $column.comments
	 */
	private String stdMaintOrgNo;
	/**
	 * $column.comments
	 */
	private String stdMaintOrgNm;
	/**
	 * $column.comments
	 */
	private String stdAsstOrgNo;
	/**
	 * $column.comments
	 */
	private String stdAsstOrgNm;
	/**
	 * $column.comments
	 */
	private String stdMaintTeamNo;
	/**
	 * $column.comments
	 */
	private String stdMaintTeamNm;
	/**
	 * $column.comments
	 */
	private String stdBlgCityNo;
	/**
	 * $column.comments
	 */
	private String stdBlgCityNm;
	/**
	 * $column.comments
	 */
	private String dataDt;
	/**
	 * $column.comments
	 */
	private Date etlTm;

}
