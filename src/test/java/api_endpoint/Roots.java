package api_endpoint;

/*
 * Swagger URI -->https://petstore.swagger.io
 * 
create user (post): --> https://petstore.swagger.io/v2/user
get user (get):https://petstore.swagger.io/v2/user/(username)
update user (put) :https://petstore.swgger.io/user/(username)
Delete user(delete) : https://petstore.swagger.io/v2/user/(username)

*/
public class Roots {
	
	 public static String base_url="https://petstore.swagger.io/v2";
	
	 //user module
	 
	 public static String post_url=base_url+"/user";
	 public static String get_url=base_url+"/user/{username}";
	 public static String put_url=base_url+"/user/{username}";
	 public static String delete_url=base_url+"/user/{username}";
	 
	 //store module
	   //here we will create the store apis
	 
	 //petmodule
	  //here we will creare the petmodule apis
	

}
