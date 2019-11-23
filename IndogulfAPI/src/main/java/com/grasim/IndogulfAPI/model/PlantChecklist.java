package com.grasim.IndogulfAPI.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "PLANT_CHECKLIST_ID")
public class PlantChecklist {

	/*@EmbeddedId
	private PlantChecklistID plantChklistId;*/
	@Id
	@Column(name = "CHECKLIST_ID")
	private String id;
	
	@Column(name = "DEPT_CD")
	private String deptCode;
	
	@Column(name = "PLANT_NM")
	private String plantName;
	
	@Column(name = "CHECKLIST_DESCR")
	private String description;
	
	@Column(name = "CHECKLIST_FORMAT")
	private String format;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZZZ")
	@Column(name = "CREAT_DT")
	private Date createDate;
	
	@Column(name = "MODIFIED_SR_NO")
	private Long modifiedSrNo;
	
	public Long getModifiedSrNo() {
		return modifiedSrNo;
	}

	public void setModifiedSrNo(Long modifiedSrNo) {
		this.modifiedSrNo = modifiedSrNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	@Override
	public String toString() {
		return "PlantChecklist [id=" + id + ", deptCode=" + deptCode + ", plantName=" + plantName + ", description="
				+ description + ", format=" + format + ", createDate=" + createDate + ", modifiedSrNo=" + modifiedSrNo
				+ "]";
	}

	/*public PlantChecklistID getPlantChklistId() {
		return plantChklistId;
	}

	public void setPlantChklistId(PlantChecklistID plantChklistId) {
		this.plantChklistId = plantChklistId;
	}
*/
}
