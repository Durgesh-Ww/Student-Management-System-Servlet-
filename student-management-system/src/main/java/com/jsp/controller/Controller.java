package com.jsp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.model.Student;

public class Controller 
{

		static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pg_sql");
		static EntityManager entityManager = entityManagerFactory.createEntityManager();
		static EntityTransaction entityTransaction = entityManager.getTransaction();
		
		public Student fetchStudent(String name)
		{
			 return entityManager.find(Student.class,name);
		}
		
		public boolean addStudent(Student student)
		{
			Student fetchStudent = fetchStudent(student.getName());
			if(fetchStudent ==null)
			{
				entityTransaction.begin();
				entityManager.persist(student);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		public boolean deleteStudent(String name)
		{
			Student fetchStudentToDelete = fetchStudent(name);
			if(fetchStudentToDelete!=null)
			{
				entityTransaction.begin();
				entityManager.remove(fetchStudentToDelete);
				entityTransaction.commit();
				return true;
			}
			return false;
		}
		
		public boolean updateStudent(Student student)
		{
				entityTransaction.begin();
				entityManager.merge(student);
				entityTransaction.commit();
				return true;
			
		}

	
		
//	 public static void main(String[] args) {
//		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pg_sqll");
//		 EntityManager entityManager = entityManagerFactory.createEntityManager();
//		 EntityTransaction entityTransaction = entityManager.getTransaction();
//		 
//		 System.out.println("generated ");
//	}
		
	

}
