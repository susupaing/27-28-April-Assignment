/*
 * @(#)EmployeeDaoImpl.java
 */
package com.example.hrms.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.example.hrms.dao.EmployeeDao;
import com.example.hrms.model.Employee;

/**
 * Implementation of the Employee DAO.
 * 
 * @author Su Su Paing
 *
 */
@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

    /**
     * Total Count of the records inserted or updated to the database.
     */
    int rowCount;

    /**
     * A factory for connections to the physical data source that this DataSource
     * object represents.
     */
    @Autowired
    DataSource dataSource;

    /**
     * Initialize the dataSource.
     */
    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    /**
     * Insert Employee Information into the database.
     * 
     * @param employee Employee
     * @return total Number of Record Count
     */
    @Override
    public int insertEmployee(List<? extends Employee> Employee) {
        rowCount = 0;
        String sql = "INSERT INTO EMPLOYEE "
                + "(EMPLOYEE_ID, JP_LEVEL_ID, DEPARTMENT_ID, POSITION_ID, EMPLOYEE_NAME, DATE_OF_BIRTH, GENDER, JOIN_DATE, MATERIAL_STATUS, EMAIL, PHONE_NUMBER, START_TIME, END_TIME) VALUES (?, ?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?, TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'))"
                + "ON CONFLICT (employee_id) DO UPDATE SET JP_LEVEL_ID=?,DEPARTMENT_ID=?,POSITION_ID=?,EMPLOYEE_NAME=?,DATE_OF_BIRTH=TO_DATE(?, 'DD/MM/YYYY'),GENDER=?,JOIN_DATE=TO_DATE(?, 'DD/MM/YYYY'),MATERIAL_STATUS=?,EMAIL=?,PHONE_NUMBER=?,START_TIME=TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS'),END_TIME=TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS')";
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Employee employee = Employee.get(i);
                ps.setInt(1, Integer.parseInt(employee.getEmployee_id()));
                ps.setInt(2, Integer.parseInt(employee.getJp_level_id()));
                ps.setInt(3, Integer.parseInt(employee.getDepartment_id()));
                ps.setInt(4, Integer.parseInt(employee.getPosition_id()));
                ps.setString(5, employee.getEmployee_name());
                ps.setString(6, employee.getDate_of_birth());
                ps.setString(7, employee.getGender());
                ps.setString(8, employee.getJoin_date());
                ps.setString(9, employee.getMaterial_status());
                ps.setString(10, employee.getEmail());
                ps.setString(11, employee.getPhone_number());
                ps.setString(12, employee.getStart_time());
                ps.setString(13, employee.getEnd_time());
                ps.setInt(14, Integer.parseInt(employee.getJp_level_id()));
                ps.setInt(15, Integer.parseInt(employee.getDepartment_id()));
                ps.setInt(16, Integer.parseInt(employee.getPosition_id()));
                ps.setString(17, employee.getEmployee_name());
                ps.setString(18, employee.getDate_of_birth());
                ps.setString(19, employee.getGender());
                ps.setString(20, employee.getJoin_date());
                ps.setString(21, employee.getMaterial_status());
                ps.setString(22, employee.getEmail());
                ps.setString(23, employee.getPhone_number());
                ps.setString(24, employee.getStart_time());
                ps.setString(25, employee.getEnd_time());
                rowCount++;
            }

            public int getBatchSize() {
                return Employee.size();
            }
        });
        return rowCount;
    }
}