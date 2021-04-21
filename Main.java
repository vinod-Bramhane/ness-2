package miniproject;


import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

import java.sql.*;
public class Main {

    private static final Employee employee = null;

	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        EmployeeDao dao = null;
		try {
			dao = EmployeeDaoFactory.getEmployeeDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Please select any one options");
        System.out.println("**************");
        System.out.println("Press 1: Insert");
        System.out.println("Press 2: Update");
        System.out.println("Press 3: Delete");
        System.out.println("Press 4: Get");
        System.out.println("**************");

        int option = scanner.nextInt();
        switch (option){
            case 1: {
                insert(employee);
                break;
            }
            case 2: {
                update(employee);
                break;
            }
            case 3: {
                delete();
                break;
            }
            case 4: {
                try {
					get();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                break;
            }
            default: {
                System.out.println("Incorrect options");
            }
        }

        List<Employee> list = null;
		try {
			list = dao.getEmployees();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for (Employee emp:list) {
            System.out.println(emp.toString());
        }
    }
    private static void insert(Employee employee){
    	 EmployeeDao dao = null;
		try {
			dao = EmployeeDaoFactory.getEmployeeDao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
          try {
			dao.addEmployee(employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private static void update(Employee employee){
    	 EmployeeDao dao = null;
		try {
			dao = EmployeeDaoFactory.getEmployeeDao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           try {
			dao.updateEmployee(employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private static void delete(){
    	EmployeeDao dao = null;
		try {
			dao = EmployeeDaoFactory.getEmployeeDao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
			dao.deleteEmployee(10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("deleted");
    }

    private static void get() throws SQLException {

        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        List<Employee> list =  dao.getEmployees();
        for (Employee emp:list) {
            System.out.println(emp.toString());
        }
    	
}
}