package miniproject;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class EmployeeDaoImpl implements EmployeeDao{

	  private static Statement statement = null;
	    private Connection conn;

	    public EmployeeDaoImpl() throws SQLException {
	        conn = ConnectionFactory.getConnection();
	        statement = conn.createStatement();
	    }

	    @Override
	    public void addEmployee(Employee employee) throws SQLException {
	        // write code to add employee into mysql database
	        String sql = "insert into employee11 values (" + employee.getName() + ", '" + employee.getEmpId() + "', '" + employee.getEmail() + "')";
	        int count = 0;
	        count = statement.executeUpdate(sql);

	        if (count > 0) {
	            System.out.println("Employee saved");
	        } else {
	            System.out.println("Not completed");
	        }
	    }

	    @Override
	    public void updateEmployee(Employee employee) throws SQLException {
	        // write code for update
	        String sql = "update employee11 set name='"+employee.getName()+"', email='"+employee.getEmail()+"' where id="+ employee.getEmpId();
	        int count = 0;
	        count = statement.executeUpdate(sql);

	        if (count > 0) {
	            System.out.println("Employee saved");
	        } else {
	            System.out.println("Not completed");
	        }
	    }

	    @Override
	    public void deleteEmployee(int id) throws SQLException {
	        // write code for delete
	        String sql = "delete from employee11 where id= "+ id;
	        int count = 0;
	        count = statement.executeUpdate(sql);

	        if (count > 0) {
	            System.out.println("Employee saved");
	        } else {
	            System.out.println("Not completed");
	        }
	    }

	    @Override
	    public Employee getEmployeeById(int id) throws SQLException {
	        // write code for employee by id
	        Employee employee = null;
	        String sql = "select * from employee11 where id = "+ id;
	        ResultSet rs = statement.executeQuery(sql);
	        if(rs.next()){
	            int empId = rs.getInt("id");
	            String name = rs.getString("name");
	            String email = rs.getString("email");
	            employee = new Employee(empId, name, email);
	        }
	        return employee;
	    }

	    @Override
	    public List<Employee> getEmployees() throws SQLException {
	        // write code to get all employees
	        List<Employee> list = new ArrayList<>();
	        String sql = "select * from employee11";
	        ResultSet rs = statement.executeQuery(sql);
	        while (rs.next()){
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            String email = rs.getString("email");
	            Employee employee = new Employee(id, name, email);
	            list.add(employee);
	        }
	        return list;
	    }
}
