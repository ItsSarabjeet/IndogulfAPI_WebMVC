package com.grasim.IndogulfAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SETTINGS")
public class Settings {

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "PARAMETER")
	private String parameter;
	
	@Column(name = "VALUE")
	private String value;
	
	@Column(name = "MODIFIED_SR_NO")
	private Long modifiedSrNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getModifiedSrNo() {
		return modifiedSrNo;
	}

	public void setModifiedSrNo(Long modifiedSrNo) {
		this.modifiedSrNo = modifiedSrNo;
	}

	@Override
	public String toString() {
		return "Settings [id=" + id + ", parameter=" + parameter + ", value=" + value + ", modifiedSrNo=" + modifiedSrNo
				+ "]";
	}
}
