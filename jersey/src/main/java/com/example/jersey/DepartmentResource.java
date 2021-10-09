package com.example.jersey;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("departments")
public class DepartmentResource {
	
	DepartmentRepsitory departmentRepository = new DepartmentRepsitory();
	
	@Path("getAll")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public java.util.List<Department> getDepartments() throws Exception{
		return departmentRepository.getAllDepartments();
	}
	@Path("addNew")
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Department addDepartment(Department department) throws Exception{
	System.out.println(department.toString());
	return departmentRepository.addDepartment(department);
	}
	
	@Path("getById/{id}")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Department getById(@PathParam("id") int id) throws Exception{
		return departmentRepository.getDepartmentById(id);
	}
//	
//	@Path("updateById/{id}")
//	@PUT
//	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
////	@Consumes(MediaType.APPLICATION_XML)
//	public Department updateById(@PathParam("id") int id,Department department){
//		return departmentRepository.updateByDepartmentId(id,department);
//	}
//	
//	@Path("deleteById")
//	@DELETE
//	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//	public Department deleteById(int id){
//		
//		return departmentRepository.deleteById(id);
//		
//		
//	}
	
}
