package com.kadiryaka.applcation;

import java.util.Date;

import org.hibernate.Session;

import com.kadiryaka.applcation.HibernateUtil;
import com.kadiryaka.entity.BaseEntity;
import com.kadiryaka.entity.SportCenter;

public class Application {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		System.out.println("Hello World!");
		
		SportCenter center = new SportCenter();
		center.setName("50.Yil Spor Center");
		center.setPhone("0212 498 78 45");
		center.setBoss("Haci Murtaza Faruk");
		center.setMonthlyPrice(new Long(100));
		center.setOldBoss("Hafiz Zülfikar");
		center.setSporterCount(new Long(45));
		
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
		
		System.out.println("yearly price = " + sCenter.getYearlyPrice());
		
		
		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
