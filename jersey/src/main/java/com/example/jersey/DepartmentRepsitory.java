package com.example.jersey;
import java.sql.Connection;
import java.sql.DriverManager;
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

//	public Department addDepartment(Department department) {
//		departments.add(department);
//		return department;
//	}
//
//	public Department getDepartmentById(int id) {
//		for(Department department:departments){
//			if(department.getDepartmentId()==id)
//				return department;
//		}
//		return new Department();
//	}
//
//	public Department updateByDepartmentId(int id,Department department) {
//		ListIterator<Department> iterator = departments.listIterator();
//		while(iterator.hasNext()){
//			Department department2 = iterator.next();
//			if(department2.getDepartmentId()==id){
//				iterator.set(department);
//				return department;
//			}
//		}
//		return new Department();
//	}
//
//	public Department deleteById(int id) {
//		ListIterator<Department> listIterator = departments.listIterator();
//		while(listIterator.hasNext()){
//			Department departments2 =listIterator.next();
//			if( departments2.getDepartmentId()==id){
//				listIterator.remove();
//				return departments2;
//			}
//		}
//		return new Department();
//	}
//	
	

}
