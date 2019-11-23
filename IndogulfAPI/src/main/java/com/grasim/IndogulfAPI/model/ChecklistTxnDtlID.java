package com.grasim.IndogulfAPI.model;

import java.io.Serializable;

public class ChecklistTxnDtlID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String txnRef;
	
	private String txnCd;
	
	private String txnVal;

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

	@Override
	public String toString() {
		return "ChecklistTxnDtlID [txnRef=" + txnRef + ", txnCd=" + txnCd + ", txnVal=" + txnVal + "]";
	}
	
	
}
