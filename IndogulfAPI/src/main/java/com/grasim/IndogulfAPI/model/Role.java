package com.grasim.IndogulfAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE_MSTR")
public class Role {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "ROLE_NAME")
	private String roleName;

	@Column(name = "MODIFIED_SR_NO")
	private Long modifiedSrNo;

	public Long getModifiedSrNo() {
		return modifiedSrNo;
	}

	public void setModifiedSrNo(Long modifiedSrNo) {
		this.modifiedSrNo = modifiedSrNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
