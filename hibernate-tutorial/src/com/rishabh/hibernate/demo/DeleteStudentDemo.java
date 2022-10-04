package com.rishabh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rishabh.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			int studentId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n Getting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			//delete the student
			System.out.println("Deleting Student: " + myStudent);
			session.delete(myStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
	}
}
