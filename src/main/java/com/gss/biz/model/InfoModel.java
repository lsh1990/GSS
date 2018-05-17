package com.gss.biz.model;

import java.util.Date;

/**
 * @Description: 需要导出的数据字段
 * @author-lsh
 * @date 2018年4月12日 下午3:35:12
 */
public class InfoModel {
	
	private String barcode;//分单号
	
	private String voyage;//总单号
	
	private String customsDesc;//海关验放指令
	
	private String createTime;//上线时间
	
	private String passType;//上线类型

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getVoyage() {
		return voyage;
	}

	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}

	public String getCustomsDesc() {
		return customsDesc;
	}

	public void setCustomsDesc(String customsDesc) {
		this.customsDesc = customsDesc;
	}


	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPassType() {
		return passType;
	}

	public void setPassType(String passType) {
		this.passType = passType;
	}
	
	

}
