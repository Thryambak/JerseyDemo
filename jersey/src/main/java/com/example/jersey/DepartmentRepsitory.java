package com.example.jersey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
	

@SuppressWarnings("unused")
public class DepartmentRepsitory {
	
	Connection con = null;
	
		public DepartmentRepsitory()  {
			try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jersey";
			String uname ="root";
			String pass = "root";
			
		 con = DriverManager.getConnection(url,uname,pass);
			}
			
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		
	

	public List<Department> getAllDepartments() throws Exception {
		// TODO Auto-generated method stub
		List<Department> departments = new ArrayList<Department>();

			
			Statement statement =  con.createStatement();
			ResultSet rSet = statement.executeQuery("select * FROM departments");
			
			while(rSet.next()){
				Department myDepartment = new Department();
				myDepartment.setDepartmentId(rSet.getInt(1));
				myDepartment.setDepartmentName(rSet.getString(2));
				departments.add(myDepartment);
				
			}
		
		
	
		return departments;
	
	}

	public Department addDepartment(Department department) throws Exception {
		
		String 	sql ="insert into departments values (?,?)";
		
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1,department.getDepartmentId());
		statement.setString(2, department.getDepartmentName());
		statement.executeUpdate();
		return department;
	}

	public Department getDepartmentById(int id) throws Exception {
		Statement statement =  con.createStatement();
		ResultSet rSet = statement.executeQuery("select * FROM departments");
		
		while(rSet.next()){
			Department myDepartment = new Department(rSet.getString(2),rSet.getInt(1));
			if (myDepartment.getDepartmentId()==id ) {
				return myDepartment;
			}

			
			
		}
		return new Department();
	}

	public Department updateByDepartmentId(int id,Department department) throws Exception {
		
		String sql = "Update departments set departmentId = ?, departmentName = ? where departmentId = ?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, department.getDepartmentId());
		statement.setString(2, department.getDepartmentName());
		statement.setInt(3, id);
		statement.executeUpdate();
		
		return  department;
	}

	public String deleteById(int id) throws Exception {
		String sql ="DELETE FROM departments where departmentId = "+id;
		Statement statement = con.createStatement();
		statement.executeUpdate(sql);
		return "Success";	
	}
	
	

}
