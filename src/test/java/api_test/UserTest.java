package api_test;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api_endpoint.UserEndPoints;
import api_payload.User;
import io.restassured.response.Response;
public class UserTest {
	
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		
		 userPayload= new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
	}
	@Test(priority=1)
	public void testpostUser()
	{
		Response res=UserEndPoints.createUser(userPayload);
		 res.then().log().all();
		 
		 Assert.assertEquals(res.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void testGetUserByName()
	{
		Response res1=UserEndPoints.readUser(this.userPayload.getUsername());
		res1.then().log().all();
		Assert.assertEquals(res1.getStatusCode(),200);
	}
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response res=UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		 res.then().log().body();
		 
		 Assert.assertEquals(res.getStatusCode(), 200);
		 
		 //check data after update
		 Response resAfterUpdate=UserEndPoints.readUser(this.userPayload.getUsername());
		 Assert.assertEquals(resAfterUpdate.getStatusCode(), 200);
	}
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		Response aftedltres = UserEndPoints.deleteUser(this.userPayload.getUsername());
		 Assert.assertEquals(aftedltres.statusCode(), 200);
	}
}
