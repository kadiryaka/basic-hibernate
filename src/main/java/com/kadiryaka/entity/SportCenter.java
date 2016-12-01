package com.kadiryaka.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "T_SPORT_CENTER")
public class SportCenter implements Serializable {

	private static final long serialVersionUID = -1147124062051267946L;

	@Id
	@GeneratedValue
	@Column(name = "C_ID")
	private Long id;
	
	@Column(name = "C_NAME")
	private String name;
	
	@Column(name = "C_PHONE")
	private String phone;
	
	@Column(name = "C_BOSS", updatable = false)
	private String boss;
	
	@Embedded
	private BaseEntity baseEntity;
	
	@Transient
	private Long sporterCount;
	
	private String oldBoss; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss == null ? "Default Boss" : boss;
	}

	public BaseEntity getBaseEntity() {
		return baseEntity;
	}

	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}

	public String getOldBoss() {
		return oldBoss;
	}

	public void setOldBoss(String oldBoss) {
		this.oldBoss = oldBoss;
	}

	public Long getSporterCount() {
		return sporterCount;
	}

	public void setSporterCount(Long sporterCount) {
		this.sporterCount = sporterCount;
	}
}
