package com.grasim.IndogulfAPI.model;

import java.io.Serializable;

public class ChecklistEquipDtlId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String txnRef;
	
	private String equipCode;

	public String getTxnRef() {
		return txnRef;
	}

	public void setTxnRef(String txnRef) {
		this.txnRef = txnRef;
	}

	public String getEquipCode() {
		return equipCode;
	}

	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}
	
	
}
