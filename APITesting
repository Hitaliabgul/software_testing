package restapitesting;

import org.testng.annotations.Test;

import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
 given()
 content type, set cookies, add auth, add param,set headers. etc
 
 when()
 get, put,post, delete
 
 then()
 validate status code, extract response, extract headers cookies and response body..
  */
public class Restassured {
	int id;
	@Test(priority=1)
	void getUsers() 
	{
	given()
	.when()
		.get("https://reqres.in/api/users?page=2")
		
		
	.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
	}
	
	//create new user
	@Test(priority=2)
	void createUser() 
	{
		
		HashMap map=new HashMap();
		map.put("name", "hitali");
		map.put("job", "QA");
	id=given()
		.contentType("application/json")
		.body(map)
	.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
	
	//.then()
	//.statusCode(201)
	//.log().all();
	}
	
	@Test(priority=3, dependsOnMethods= {"createUser"})
	void updateUser()
	{
		
		HashMap map=new HashMap();
		map.put("name", "vijaya");
		map.put("job", "QA");
	given()
		.contentType("application/json")
		.body(map)
	.when()
		.put("https://dummy.restapiexample.com/api/v1/update/21")
	.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority=4)
	void deleteUser()
	{
		given()
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
	}
	
}
