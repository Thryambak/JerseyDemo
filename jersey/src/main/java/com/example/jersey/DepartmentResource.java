package com.example.jersey;



import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("departments")
public class DepartmentResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public java.util.List<Department> getDepartments(){
		Department mydept = new Department("Computer Science", 01);
		Department medept2 = new Department("Is", 02);
		
		
		return Arrays.asList(mydept,medept2);
	}
	
	
	
}
