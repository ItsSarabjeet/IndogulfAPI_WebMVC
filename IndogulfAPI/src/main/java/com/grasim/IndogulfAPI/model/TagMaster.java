package com.grasim.IndogulfAPI.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLANT_CHECKLIST_TAG_MST")
public class TagMaster {

	@Id
	@Column(name = "TAG_ID")
	private String id;

	@Column(name = "TAG_DESCR")
	private String descr;

	@Column(name = "CREAT_DT")
	private Date createDt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	public String toString() {
		return "TagMaster [id=" + id + ", descr=" + descr + ", createDt=" + createDt + "]";
	}

}
