package com.grasim.IndogulfAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@IdClass(ChecklistEquipDtlId.class)
@Table(name = "PLANT_CHECKLIST_EQUIP_STATUS")
public class ChecklistEquipDtl {
	@Id
	@Column(name = "TXN_REF")
	private String txnRef;

	@Id
	@Column(name = "EQUIP_CODE")
	private String equipCode;

	@Column(name = "IS_COMPLETED")
	@Type(type = "yes_no")
	private boolean completed;

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

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
