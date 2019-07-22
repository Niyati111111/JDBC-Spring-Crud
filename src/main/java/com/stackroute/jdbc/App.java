package com.stackroute.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class App {
    public static void main(String[] args) {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        //Inserting values into the Employee table
        EmployeeDetailsDao dao=applicationContext.getBean("edao",EmployeeDetailsDao.class);
        int status=dao.insertEmployee(new EmployeeDetails("Shawn",15,2000000,"male"));
        System.out.println(status);
        //Updating the Employee table
        System.out.println("----Updating Record with ID -----" );
        dao.updateEmployee(5, "Sally","female");
        //Performing delete operation
        System.out.println("delete");
        EmployeeDetails e=new EmployeeDetails();
        e.setId(15);
        status=dao.deleteEmployee(e);
        System.out.println(status);
        //Performing select query
        System.out.println("select query");
        List<EmployeeDetails> list=dao.retriveEmployees();
        for(EmployeeDetails e1:list)
            System.out.println(e1);
    }
}
