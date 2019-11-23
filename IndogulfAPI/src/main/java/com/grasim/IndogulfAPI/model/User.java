package com.grasim.IndogulfAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_MSTR")
public class User {

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "EMP_CODE")
	private String empCode;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "ENC_PASSWD")
	private String passwd;
	
	@Column(name = "IS_ACTIVE")
	private String active;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "MODIFIED_SR_NO")
	private Long modifiedSrNo;
	
	@Column(name = "ROLE_ID")
	private Long roleId;
	
	

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", empCode=" + empCode + ", name=" + name + ", passwd=" + passwd + ", active="
				+ active + ", username=" + username + ", modifiedSrNo=" + modifiedSrNo + "]";
	}

}
