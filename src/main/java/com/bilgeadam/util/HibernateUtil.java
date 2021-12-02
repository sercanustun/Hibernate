package com.bilgeadam.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.egitim.enumx.PencilEntity;
import com.bilgeadam.egitim.relation.oneToMany.Student;
import com.bilgeadam.egitim.relation.oneToMany.Teacher;
import com.bilgeadam.entity.BilgeAdamEntity;
import com.bilgeadam.entity.EticaretEntity;
import com.bilgeadam.entity.StudentEntity;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = sessionFactoryHibernate();
	
	// method
	private static SessionFactory sessionFactoryHibernate() {
		try {
			// instance
			Configuration configuration = new Configuration();
			
			// entity classlarımızı buraya ekleyeceğiz
			configuration.addAnnotatedClass(StudentEntity.class);
			configuration.addAnnotatedClass(BilgeAdamEntity.class);
			configuration.addAnnotatedClass(EticaretEntity.class);
			configuration.addAnnotatedClass(PencilEntity.class);
			
			// composition
			configuration.addAnnotatedClass(Student.class);
			configuration.addAnnotatedClass(Teacher.class);
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// dış dünyada bununla bu classa erişim sağlayabileceğim.
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
}
