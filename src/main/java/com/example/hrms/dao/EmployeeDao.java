/*
 * @(#)EmployeeDao.java
 */
package com.example.hrms.dao;

import java.util.List;
import com.example.hrms.model.Employee;

/**
 * Interface of the Employee DAO.
 * 
 * @author Su Su Paing
 *
 */
public interface EmployeeDao {

	/**
    * Insert Employee Information into the database.
    * 
    * @param employee Employee
    * @return total Number of Record Count
    */
	public int insertEmployee(List<? extends Employee> employee);
}