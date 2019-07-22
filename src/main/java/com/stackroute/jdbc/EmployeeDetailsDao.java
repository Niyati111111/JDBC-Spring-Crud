package com.stackroute.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDetailsDao {
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //Logic for insert statement
    public int insertEmployee(EmployeeDetails employee)
    {
        String query= "insert into EmployeeDetails values('"+employee.getName()+"','"+employee.getId()+"','"+employee.getSalary()+"',' "+employee.getGender()+" ')";
        return jdbcTemplate.update(query);
    }
    //Logic for Update statement
    public void updateEmployee(Integer employeeId, String employeeName, String gender){
        String SQL = "update EmployeeDetails set name = ?, gender = ? where id = ?";
        jdbcTemplate.update(SQL, employeeName, gender, employeeId);
        System.out.println("Updated Record with ID = " + employeeId );
    }
    //Logic for delete operation
    public int deleteEmployee(EmployeeDetails employee)
    {
        String query="delete from EmployeeDetails where id = '"+employee.getId()+"' ";
        return jdbcTemplate.update(query);
    }
    //Logic for select operation
    public List<EmployeeDetails> retriveEmployees(){
        String query="select * from EmployeeDetails";
        final List<EmployeeDetails> list = new ArrayList<EmployeeDetails>();
        return jdbcTemplate.query(query,new ResultSetExtractor<List<EmployeeDetails>>(){
                    @Override
                    public List<EmployeeDetails> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        while (resultSet.next()) {
                            EmployeeDetails e = new EmployeeDetails();
                            e.setName(resultSet.getString(1));
                            e.setId(resultSet.getInt(2));
                            e.setSalary(resultSet.getInt(3));
                            e.setGender(resultSet.getString(4));
                            list.add(e);
                        }
                        return list;
                    }
                }
        );
    }
}
