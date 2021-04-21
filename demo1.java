package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/student", "root", "");
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery("select * from employee1");
	            while (rs.next())
	                System.out.println(rs.getString(1) + "  " +rs.getInt(2));
	            con.close();
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }

	    }
	}


