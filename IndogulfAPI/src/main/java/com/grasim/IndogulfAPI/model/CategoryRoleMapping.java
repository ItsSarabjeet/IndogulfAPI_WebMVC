package com.grasim.IndogulfAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "CATEGORY_ROLE_MAPPING")
public class CategoryRoleMapping {

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "ROLE_ID")
	private Long roleId;

	@Column(name = "CATEGORY_ID")
	private String categoryId;

	@Column(name = "MODIFIED_SR_NO")
	private Long modifiedSrNo;
	
	@Type(type = "yes_no")
	@Column(name = "ACTIVE")
	private boolean active;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "CategoryRoleMapping [id=" + id + ", roleId=" + roleId + ", categoryId=" + categoryId + ", modifiedSrNo="
				+ modifiedSrNo + ", active=" + active + "]";
	}

}
