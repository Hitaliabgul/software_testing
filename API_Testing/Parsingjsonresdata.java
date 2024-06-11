package parsingjsonresonse;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
public class Parsingjsonresdata {
	//approach 1
	@Test(priority=1)
	void testjsondata() 
	{
		//approach 1 here we use jsonpathfinder website to findpath
		given()
			.contentType("ContentType.JSON")
		.when()
		.get("http://localhost:3000/store")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json")
		.body("book[2].title", equalTo("The lord of the rings"));
	}
	
	//approach 2 usefull should use this approch
	@Test(priority=2)
	void testjsondataapp2()
	{
		
		Response res=given()
			.contentType("ContentType.JSON")
		.when()
			.get("http://localhost:3000/store");
	
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"),"application/json");
		String bookname=res.jsonPath().get("book[2].title").toString();
		Assert.assertEquals(bookname, "The lord of the rings");
	}
	
	@Test(priority=3)
	void testjsonresbodydata()
	{
		Response res=given()
				.contentType(ContentType.JSON)
			.when()
				.get("http://localhost:3000/store");
		
		//capture all the titles using json object class
		JSONObject jo=new JSONObject(res.asString());  //converting response to json obj type
		/*
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String booktitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(booktitle);
		}
		*/
		//check particular book available
		boolean status=false;
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String booktitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			if(booktitle.equals("The lord of the rings"))
			{
				status=true;
				break;
			}
		}
		Assert.assertEquals(status, true);
		System.out.println("title found");
	}
	
	@Test(priority=4)
	void countpriceofbooks()
	{
		Response res=given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store");
		double price=0;
		JSONObject js=new JSONObject(res.asString());
		for(int j=0;j<js.getJSONArray("book").length();j++)
		{
			String prices=js.getJSONArray("book").getJSONObject(j).get("price").toString();
			System.out.println(prices);
			price=price+Double.parseDouble(prices);
		}
		
		System.out.println("total"+price);
		Assert.assertEquals(price, 401.0);
		
	}
}
