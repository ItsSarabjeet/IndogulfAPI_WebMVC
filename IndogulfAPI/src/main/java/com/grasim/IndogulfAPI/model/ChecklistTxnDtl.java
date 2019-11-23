package com.grasim.IndogulfAPI.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@IdClass(ChecklistTxnDtlID.class)
@Table(name="PLANT_CHECKLIST_TXN_DTL")
public class ChecklistTxnDtl {
	

	@Id
	@Column(name = "TXN_REF")
	private String txnRef;
	
	@Id
	@Column(name = "TXN_CD")
	private String txnCd;
	
	@Id
	@Column(name = "TXN_VAL")
	private String txnVal;
	
	//@JsonFormat(pattern = "EEE MMM dd HH:mm:ss z yyyy")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZZZ")
	@Column(name = "DATE_TIME")
	private Date dateTime;
	
	public String getTxnRef() {
		return txnRef;
	}
	public void setTxnRef(String txnRef) {
		this.txnRef = txnRef;
	}
	public String getTxnCd() {
		return txnCd;
	}
	public void setTxnCd(String txnCd) {
		this.txnCd = txnCd;
	}
	public String getTxnVal() {
		return txnVal;
	}
	public void setTxnVal(String txnVal) {
		this.txnVal = txnVal;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "ChecklistTxnDtl [txnRef=" + txnRef + ", txnCd=" + txnCd + ", txnVal=" + txnVal + ", dateTime="
				+ dateTime + "]";
	}
	
}
