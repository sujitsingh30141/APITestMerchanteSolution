package Test_Cases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ResourceCommentsTests {

	@Test
	public void resource_Comments_Post() 
	{
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("postId", "2011");
		json.put("id", "6178439");
		json.put("name", "This is the Sujit Singh");
		json.put("email", "sujit@example.com");
		json.put("body", "Testing Body");
		request.body(json.toJSONString());
		Response response = request.post(" http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/comments");
				int code = response.getStatusCode();
		
		Assert.assertEquals(code, 201);
		
				
	}
	
	@Test
	public void resource_Comments_Get() {
		Response resp =	RestAssured.get(" http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/comments");
		
		int code = resp.getStatusCode();
		
		Assert.assertEquals(code, 200);
		
	}
	
	@Test
	public void resource_Comments_Put() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		JSONObject json = new JSONObject();
		json.put("postId", "2011");
		json.put("id", "6178439");
		json.put("name", "This is the Sujit Singh Updating...");
		json.put("email", "sujit@example.com Updating..");
		json.put("body", "Testing Body Updating...");
		json.put("NewFieldTest", "HelloNewField");
		request.body(json.toJSONString());
		Response response = request.put(" http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/comments/6178439");
				int code = response.getStatusCode();
		
		Assert.assertEquals(code, 200);
				
	}
	
	
	
	
	
}
