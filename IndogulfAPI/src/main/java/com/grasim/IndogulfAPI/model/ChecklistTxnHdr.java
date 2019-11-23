package com.grasim.IndogulfAPI.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@IdClass(ChecklistTxnHdrID.class)
@Table(name = "PLANT_CHECKLIST_TXN_HDR")
public class ChecklistTxnHdr {

	//@JsonFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZZZ")
	@Id
	@Column(name = "TXN_DT")
	private Date txnDate;

	@JsonFormat(pattern = "HH:mm")
	@Id
	@Column(name = "TXN_TIME")
	private String txnTime;

	@Id
	@Column(name = "CHECKLIST_ID")
	private String checklistId;

	@Id
	@Column(name = "TXN_REF")
	private String txnRef;

	@Column(name = "TXN_RMKS")
	private String txnRemarks;

	@Column(name = "CREAT_USR_ID")
	private Long createdBy;

	//@JsonFormat(pattern = "MMM dd, yyyy hh:mm:ss a")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZZZ")
	@Column(name = "CREAT_DT")
	private Date createdOn;
	
	//@Generated(GenerationTime.INSERT)
	@Column(name = "MODIFIED_SR_NO")
	private Long modifiedSrNo;

//	@OneToMany(cascade = CascadeType.ALL)
	@Transient
	private List<ChecklistEquipDtl> equipDtls;
	
//	@OneToMany(cascade = CascadeType.ALL)
	@Transient
	private List<ChecklistTxnDtl> checklistDtls;

	@Column(name = "STATUS")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getModifiedSrNo() {
		return modifiedSrNo;
	}

	public void setModifiedSrNo(Long modifiedSrNo) {
		this.modifiedSrNo = modifiedSrNo;
	}

	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

	public String getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}

	public String getChecklistId() {
		return checklistId;
	}

	public void setChecklistId(String checklistId) {
		this.checklistId = checklistId;
	}

	public String getTxnRef() {
		return txnRef;
	}

	public void setTxnRef(String txnRef) {
		this.txnRef = txnRef;
	}

	public String getTxnRemarks() {
		return txnRemarks;
	}

	public void setTxnRemarks(String txnRemarks) {
		this.txnRemarks = txnRemarks;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public List<ChecklistTxnDtl> getChecklistDtls() {
		return checklistDtls;
	}

	public void setChecklistDtls(List<ChecklistTxnDtl> checklistDtls) {
		this.checklistDtls = checklistDtls;
	}

	public List<ChecklistEquipDtl> getEquipDtls() {
		return equipDtls;
	}

	public void setEquipDtls(List<ChecklistEquipDtl> equipDtls) {
		this.equipDtls = equipDtls;
	}

	@Override
	public String toString() {
		return "ChecklistTxnHdr [txnDate=" + txnDate + ", txnTime=" + txnTime + ", checklistId=" + checklistId
				+ ", txnRef=" + txnRef + ", txnRemarks=" + txnRemarks + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", modifiedSrNo=" + modifiedSrNo + ", checklistDtls=" + checklistDtls + ", status="
				+ status + "]";
	}

}
