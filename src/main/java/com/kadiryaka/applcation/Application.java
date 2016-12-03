package com.kadiryaka.applcation;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.kadiryaka.applcation.HibernateUtil;
import com.kadiryaka.entity.Address;
import com.kadiryaka.entity.BaseEntity;
import com.kadiryaka.entity.SportCenter;

public class Application {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		SportCenter center = new SportCenter();
		center.setName("75.Yil Spor Center");
		center.setPhone("0212 498 78 45");
		center.setBoss("Haci Murtaza Faruk");
		center.setMonthlyPrice(new Long(100));
		center.setOldBoss("Hafiz Zülfikar");
		center.setSporterCount(new Long(45));
		center.getAdvisorName().add("Yusuf Hoca");
		center.getAdvisorName().add("Ridvan Hoca");
		center.getContactMap().put("Kadir", "Yaka");
		center.getContactMap().put("Ali", "Bozkurt");
		
		Address address = new Address();
		address.setCity("Istanbul");
		address.setStreet("Sultangazi");
		address.setZipCode("34000");
		
		Address address2 = new Address();
		address2.setCity("Sakarya");
		address2.setStreet("Cark");
		address2.setZipCode("54000");
		
		center.getAddress().add(address);
		center.getAddress().add(address2);
		
		BaseEntity baseEntity = new BaseEntity();
		baseEntity.setCreateDate(new Date());
		baseEntity.setUpdateDate(new Date());
		baseEntity.setIsDeleted(false);
		
		center.setBaseEntity(baseEntity);

		session.save(center);
		session.flush();
		session.getTransaction().commit();
		
		SportCenter sCenter = (SportCenter)session.get(SportCenter.class, center.getId());
		
		session.refresh(sCenter);
		
		/*
		 * For @Formula
		 */
		System.out.println("yearly price = " + sCenter.getYearlyPrice());
		
		/*
		 * For Collection List
		 */
		Collection<String> advisorNameList = sCenter.getAdvisorName();
		
		for (String advisor: advisorNameList) {
			System.out.println("Advisor Name in CollectionList = " + advisor);
		}
		
		/*
		 * For HashMap
		 */
		Map<String, String> contactMap = sCenter.getContactMap();
		for (Map.Entry<String, String> entry : contactMap.entrySet()) {
			System.out.println("Contact name : " + entry.getKey() + " Contact Surname : " + entry.getValue());
		}
		
		
		/*
		 * For Address List 
		 */
		List<Address> addressList = sCenter.getAddress();
		
		for (Address addressField: addressList) {
			System.out.println("Address City = " + addressField.getCity());
		}

		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
