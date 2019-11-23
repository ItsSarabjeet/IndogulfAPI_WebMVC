package com.grasim.IndogulfAPI.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@IdClass(PlantChecklistParamTagLinkID.class)
@Table(name = "PLANT_CHECKLIST_PARAM_TAG_LNK")
public class PlantChecklistParamTagLink {

	@Id
	@Column(name = "CHECKLIST_ID")
	private String checklistId;

	@Id
	@Column(name = "PARAM_ID")
	private String paramId;

	@Id
	@Column(name = "TAG_ID")
	private String tagId;

	@Id
	@Column(name = "TXN_CD")
	private String txnCode;

	@Column(name = "PARAM_DESCR")
	private String descr;

	@Column(name = "TXN_UOM")
	private String unitOfMeasure;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZZZ")
	@Column(name = "CREAT_DT")
	private Date createDt;

	@Column(name = "TXN_DFLT")
	private String defaultValue;
	
	@Column(name = "MODIFIED_EQUIP_SR_NO")
	private Long modifiedEquipSrNo;

	@Transient
	private String equipCode;

	public Long getModifiedEquipSrNo() {
		return modifiedEquipSrNo;
	}

	public void setModifiedEquipSrNo(Long modifiedEquipSrNo) {
		this.modifiedEquipSrNo = modifiedEquipSrNo;
	}

	public String getEquipCode() {
		return equipCode;
	}

	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}

	public String getChecklistId() {
		return checklistId;
	}

	public void setChecklistId(String checklistId) {
		this.checklistId = checklistId;
	}

	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public String getTxnCode() {
		return txnCode;
	}

	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	@Override
	public String toString() {
		return "PlantChecklistParamTagLink [checklistId=" + checklistId + ", paramId=" + paramId + ", tagId=" + tagId
				+ ", txnCode=" + txnCode + ", descr=" + descr + ", unitOfMeasure=" + unitOfMeasure + ", createDt="
				+ createDt + ", defaultValue=" + defaultValue + ", modifiedEquipSrNo=" + modifiedEquipSrNo
				+ ", equipCode=" + equipCode + "]";
	}

}
