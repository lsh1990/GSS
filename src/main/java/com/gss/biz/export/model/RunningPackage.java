package com.gss.biz.export.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the running_package database table.
 * 
 */
@Entity
@Table(name="running_package")
@NamedQuery(name="RunningPackage.findAll", query="SELECT r FROM RunningPackage r")
public class RunningPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String barcode;

	private String coords;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Column(name="edi_datagram_id")
	private int ediDatagramId;

	private int height;

	@Column(name="line_no")
	private String lineNo;

	@Column(name="operator_id")
	private int operatorId;

	@Column(name="photo_with_xray")
	private String photoWithXray;

	@Column(name="sort_parcels_flag")
	private String sortParcelsFlag;

	private double weight;

	@Column(name="weight_status")
	private int weightStatus;

	private int width;

	@Column(name="xray_image_name")
	private String xrayImageName;

	@Column(name="xray_image_relative_path")
	private String xrayImageRelativePath;

	public RunningPackage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getCoords() {
		return this.coords;
	}

	public void setCoords(String coords) {
		this.coords = coords;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getEdiDatagramId() {
		return this.ediDatagramId;
	}

	public void setEdiDatagramId(int ediDatagramId) {
		this.ediDatagramId = ediDatagramId;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getLineNo() {
		return this.lineNo;
	}

	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	public int getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public String getPhotoWithXray() {
		return this.photoWithXray;
	}

	public void setPhotoWithXray(String photoWithXray) {
		this.photoWithXray = photoWithXray;
	}

	public String getSortParcelsFlag() {
		return this.sortParcelsFlag;
	}

	public void setSortParcelsFlag(String sortParcelsFlag) {
		this.sortParcelsFlag = sortParcelsFlag;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getWeightStatus() {
		return this.weightStatus;
	}

	public void setWeightStatus(int weightStatus) {
		this.weightStatus = weightStatus;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getXrayImageName() {
		return this.xrayImageName;
	}

	public void setXrayImageName(String xrayImageName) {
		this.xrayImageName = xrayImageName;
	}

	public String getXrayImageRelativePath() {
		return this.xrayImageRelativePath;
	}

	public void setXrayImageRelativePath(String xrayImageRelativePath) {
		this.xrayImageRelativePath = xrayImageRelativePath;
	}

	@Override
	public String toString() {
		return "RunningPackage [id=" + id + ", barcode=" + barcode + ", coords=" + coords + ", createTime=" + createTime
				+ ", ediDatagramId=" + ediDatagramId + ", height=" + height + ", lineNo=" + lineNo + ", operatorId="
				+ operatorId + ", photoWithXray=" + photoWithXray + ", sortParcelsFlag=" + sortParcelsFlag + ", weight="
				+ weight + ", weightStatus=" + weightStatus + ", width=" + width + ", xrayImageName=" + xrayImageName
				+ ", xrayImageRelativePath=" + xrayImageRelativePath + "]";
	}
	
}