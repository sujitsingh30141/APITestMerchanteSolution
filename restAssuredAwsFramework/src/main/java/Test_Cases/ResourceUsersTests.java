package Test_Cases;

/*
 * Auther: Sujit Singh
 */

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class ResourceUsersTests {
	
	@Test
	public void resource_Users_Post() 
	{
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("company", "Microsoft");
		json.put("id", "6178439");
		json.put("name", "This is the Sujit Singh");
		json.put("email", "sujit@example.com");
		json.put("address", "Atlanta, GA USA");
		request.body(json.toJSONString());
		Response response = request.post(" http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/users");
				int code = response.getStatusCode();
		
		Assert.assertEquals(code, 201);
		
				
	}
	
	@Test
	public void resource_Users_Get() {
		Response resp =	RestAssured.get(" http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/users");
		
		int code = resp.getStatusCode();
		
		Assert.assertEquals(code, 200);
		
	}
	
	@Test 
	public void resource_Users_Put() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("company", "Oracle");
		json.put("id", "6178439");
		json.put("name", "This is the Sujit Singh");
		json.put("email", "sujit@example.com");
		json.put("address", "Atlanta, GA usa");
		request.body(json.toJSONString());
		Response response = request.put(" http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/users/6178439");
				int code = response.getStatusCode();
		
		Assert.assertEquals(code, 200);
				
	}
	

}
