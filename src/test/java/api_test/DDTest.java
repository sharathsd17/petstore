package api_test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api_endpoint.UserEndPoints;
import api_payload.User;
import api_utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest 
{             //create user presnt in excel file
	           @Test(priority=1,dataProvider="Data", dataProviderClass=DataProviders.class)
               public void testPostUser(String UserID,String userName,String FirstName,String LastName ,String Email,String Password,String Phone)
               {
            	   
            	   User userpayload= new User();
            	   userpayload.setId(Integer.parseInt(UserID));
            	   userpayload.setUsername(userName);
            	   userpayload.setFirstName(FirstName);
            	   userpayload.setLastName(LastName);
            	   userpayload.setEmail(Email);
            	   userpayload.setPassword(Password);
            	   userpayload.setPhone(Phone);
            	   
            	   Response res=UserEndPoints.createUser(userpayload);
          		
          		 
          		 Assert.assertEquals(res.getStatusCode(), 200);
            	      
               }
	           
	           @Test(priority =2, dataProvider="userName", dataProviderClass=DataProviders.class)
	           public void testDeleteUserByName(String userName)
               {
	        	   Response aftedltres = UserEndPoints.deleteUser(userName);
	      		 Assert.assertEquals(aftedltres.getStatusCode(), 200);
	        	   
               }
	           
	           
               
}
