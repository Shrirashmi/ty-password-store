package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Employee;

public class EmployeeDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shri");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Employee saveEmployee(Employee employee) { 
	
	entityTransaction.begin();
	entityManager.persist(employee);
	entityTransaction.commit();
	return employee;
	}
	
	public List<Employee> validateEmployee(String name, String phone) {
		
		String sql = "SELECT e FROM Employee e WHERE e.name=?1 AND e.phone=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, name);
		query.setParameter(2, phone);
		return query.getResultList();
	}
}
