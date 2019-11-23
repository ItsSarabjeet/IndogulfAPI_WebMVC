package com.grasim.IndogulfAPI.model;

import java.io.Serializable;

public class PlantChecklistParamTagLinkID implements Serializable {

	/* CHECKLIST_ID, PARAM_ID, TAG_ID, TXN_CD */
	private String checklistId;
	private String paramId;
	private String tagId;
	private String txnCode;

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

	@Override
	public String toString() {
		return "PlantChecklistParamTagLinkID [checklistId=" + checklistId + ", paramId=" + paramId + ", tagId=" + tagId
				+ ", txnCode=" + txnCode + "]";
	}

}
