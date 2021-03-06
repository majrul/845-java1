package com.lti.resource;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")
public class HelloResource {

	//http://localhost:8181/RESTApp/api/hello
	/*@GET
	public String hello() {
		return "Hello from JAX-RS";
	}*/
	
	//http://localhost:8181/RESTApp/api/hello?name=Majrul
	/*@GET
	public String hello(@QueryParam("name") String name) {
		return "Hello " + name +". Welcome to JAX-RS";
	}*/
	
	//http://localhost:8181/RESTApp/api/hello/Majrul
	/*@Path("/{name}")
	@GET
	public String hello(@PathParam("name") String name) {
		return "Hello " + name +". Welcome to JAX-RS";
	}*/
	
	//http://localhost:8181/RESTApp/api/hello;name=Majrul
	@GET
	public String hello(@MatrixParam("name") String name) {
		return "Hello " + name +". Welcome to JAX-RS";
	}
	
}
