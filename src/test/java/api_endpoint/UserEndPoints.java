package api_endpoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api_payload.User;

//userEndPoints.java
//Created for perform Create,Read,Delete requests the userAPI

public class UserEndPoints {
	
	public static Response createUser(User payload)
	{
		Response res=given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(payload)
		 
		.when()
		.post(Roots.post_url);
		return res;
	}
	public static Response readUser(String userName)
	{
		Response res=given()
		  .pathParam("username",userName)
		 
		.when()
		.get(Roots.get_url);
		
		return res;
	}
	public static Response updateUser(String userName ,User payload)
	{
		Response res=given()
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .pathParam("username",userName)
		 .body(payload)
		 
		.when()
		.put(Roots.put_url);
		return res;
	}
		public static Response deleteUser(String userName)
		{
			Response res=given()
			  .pathParam("username",userName)
			 
			.when()
			.delete(Roots.delete_url);
			
			return res;
		}
	
}
