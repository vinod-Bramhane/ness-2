package com.core1.test3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;


import com.core1.test3.entities.Employee;



public class EmployeeDao {

	
private HibernateTemplate hibernateTemplate;
	
	// insert employee
	@Transactional
	public int addEmployee(Employee employee) {
		Integer rows = (Integer)hibernateTemplate.save(employee);
		return rows;
	}
	public Employee getEmployeeById(int id) {
		Employee employee= hibernateTemplate.get(Employee.class, id);
		return employee;
	}
	
	public List<Employee> getAllEmployee() {
		List<Employee> employees= hibernateTemplate.loadAll(Employee.class);
		return employees;
	}
	@Transactional
	public void update(Employee updateEmployee) {
		 hibernateTemplate.update(updateEmployee);
		
	}
	@Transactional
	public void delete(int id) {
		Employee employee= hibernateTemplate.get(Employee.class, id);
		hibernateTemplate.delete(employee);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
