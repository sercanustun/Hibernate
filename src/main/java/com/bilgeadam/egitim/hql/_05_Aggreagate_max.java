package com.bilgeadam.egitim.hql;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.util.HibernateUtil;

public class _05_Aggreagate_max {
	// logger
	private static final Logger logger = LogManager.getLogger(_05_Aggreagate_max.class);
	
	public static void main(String[] args) {
		// Session
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		// Javada: bigData
		// Sql : big_data
		
		// SQL count
		// select count(big_data) from student;
		String hql = "select max(tcNumber) from StudentEntity";
		
		// kodlar
		TypedQuery<Integer> typedQuery = session.createQuery(hql, Integer.class);
		Integer bigDataCounter = typedQuery.getSingleResult();
		logger.info("Sonuç:  " + bigDataCounter);
		
	}
}
