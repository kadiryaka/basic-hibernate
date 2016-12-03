package com.kadiryaka.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

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
	
	@Column(name = "C_M_PRICE")
	private Long monthlyPrice;
	
	private String oldBoss; 
	
	@Formula("C_M_PRICE*12")
	private Long yearlyPrice;
	
	@ElementCollection
	@CollectionTable(name = "T_SPORT_ADVISOR", joinColumns = @JoinColumn(name = "C_ID"))
	@Column(name = "ADVIDOR_NAME")
	private Collection<String> advisorName = new ArrayList<String>();

	@ElementCollection
	@CollectionTable(name = "T_CONTACT", joinColumns = @JoinColumn(name = "C_ID"))
	@MapKeyColumn( name = "CONTACT_NAME")
	@Column(name = "CONTACT_SURNAME")
	private Map<String, String> contactMap = new HashMap<String, String>();
	
	@ElementCollection
	@CollectionTable(name = "T_CENTER_ADDRESS", joinColumns = @JoinColumn(name = "C_ID"))
	@AttributeOverrides({@AttributeOverride(name="city", column=@Column(name="CITY")),
	@AttributeOverride(name="zipCode", column=@Column(name="ZIP_CODE"))})
	
	private List<Address> address = new ArrayList<Address>();
	
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

	public Long getMonthlyPrice() {
		return monthlyPrice;
	}

	public void setMonthlyPrice(Long monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	public Long getYearlyPrice() {
		return yearlyPrice;
	}

	public void setYearlyPrice(Long yearlyPrice) {
		this.yearlyPrice = yearlyPrice;
	}

	public Collection<String> getAdvisorName() {
		return advisorName;
	}

	public void setAdvisorName(Collection<String> advisorName) {
		this.advisorName = advisorName;
	}

	public Map<String, String> getContactMap() {
		return contactMap;
	}

	public void setContactMap(Map<String, String> contactMap) {
		this.contactMap = contactMap;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
}
