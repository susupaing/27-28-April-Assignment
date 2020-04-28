/*
 * @(#)EmployeeExcelRowMapper.java
 */
package com.example.hrms.config;

import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;
import com.example.hrms.model.Employee;

/**
 * Map the Excel Column and the Employee Information.
 * 
 * @author Su Su Paing
 *
 */
public class EmployeeExcelRowMapper implements RowMapper<Employee> {

    /**
     * Read Employee Information from the Excel.
     * 
     * @param RowSet
     * @return Employee
     */
    @Override
    public Employee mapRow(RowSet rowSet) throws Exception {
        Employee employee = new Employee();
        employee.setEmployee_id(rowSet.getColumnValue(0));
        employee.setJp_level_id(rowSet.getColumnValue(1));
        employee.setDepartment_id(rowSet.getColumnValue(2));
        employee.setPosition_id(rowSet.getColumnValue(3));
        employee.setEmployee_name(rowSet.getColumnValue(4));
        employee.setDate_of_birth(rowSet.getColumnValue(5));
        employee.setGender(rowSet.getColumnValue(6));
        employee.setJoin_date(rowSet.getColumnValue(7));
        employee.setMaterial_status(rowSet.getColumnValue(8));
        employee.setEmail(rowSet.getColumnValue(9));
        employee.setPhone_number(rowSet.getColumnValue(10));
        employee.setStart_time(rowSet.getColumnValue(11));
        employee.setEnd_time(rowSet.getColumnValue(12));
        return employee;
    }
}