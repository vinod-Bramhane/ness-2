package com.core1.test3;

import java.util.Scanner;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */



import com.core1.test3.dao.EmployeeDao;
import com.core1.test3.entities.Employee;


public class App 
{
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		EmployeeDao dao = context.getBean("employeeDao", EmployeeDao.class);

		Scanner s = new Scanner(System.in);
		System.out.println("enter the value");
		System.out.println("1 add");
		System.out.println("2 get all employee");
		System.out.println("3 get by id");
		System.out.println("4 udate ");
		System.out.println("5 delete");
boolean flag=true;
		while (flag) {
			System.out.println("enter the choice");
			int choice = s.nextInt();
			try {
				switch (choice) {
				case 1:
					Employee employee = new Employee();
					System.out.println("enter id");

					employee.setId(s.nextInt());
					System.out.println("enter name");
					employee.setName(s.next());
					System.out.println("enter email");
					employee.setEmail(s.next());

					dao.addEmployee(employee);
					System.out.println("row added");
					break;
				case 2:

					List<Employee> list = dao.getAllEmployee();
					for (Employee list1 : list) {
						System.out.println(list1);
					}
					System.out.println("elements");
					break;
				case 3:
					System.out.println("enter id");
					Employee employee1 = dao.getEmployeeById(s.nextInt());
					System.out.println(employee1);
					break;
				case 4:
					Employee employee2 = new Employee();
					System.out.println("enter id");

					employee2.setId(s.nextInt());
					System.out.println("enter name");
					employee2.setName(s.next());
					System.out.println("enter email");
					employee2.setEmail(s.next());

					dao.update(employee2);
					System.out.println("row updated");
					break;
				case 5:
					System.out.println("enter id");
					dao.delete(s.nextInt());
					System.out.println("row deleted");
					
					flag=false;
					break;

				default:
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

//         
//         Employee newEmployee = new Employee();
//         newEmployee.setId(1);
//         newEmployee.setName("Mark");
//         newEmployee.setEmail("m@gmail.com");
//         
//         int result =  dao.addEmployee(newEmployee);
//         System.out.println("("+result+") rows inserted...");

	}
}
