package com.grasim.IndogulfAPI.model;

import java.io.Serializable;
import java.util.Date;

public class ChecklistTxnHdrID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date txnDate;

	private String txnTime;

	private String checklistId;

	private String txnRef;

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

	@Override
	public String toString() {
		return "ChecklistTxnHdrID [txnDate=" + txnDate + ", txnTime=" + txnTime + ", checklistId=" + checklistId
				+ ", txnRef=" + txnRef + "]";
	}
	
	
}
