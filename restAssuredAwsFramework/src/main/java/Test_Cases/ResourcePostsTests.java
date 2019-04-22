package Test_Cases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

	
	public class ResourcePostsTests {
	 
		
		@Test
		public void resource_Posts_Post() 
		{
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/json");
			
			JSONObject json = new JSONObject();
			json.put("id", "6178439");
			json.put("userId", "2011");
			json.put("body", "This is the Sujit's body");
			json.put("title", "This is Sujit's Title");
			request.body(json.toJSONString());
			Response response = request.post(" http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/posts");
					int code = response.getStatusCode();
			
			Assert.assertEquals(code, 201);
			
					
		}
		
		@Test
		public void resource_Posts_Get() {
			Response resp =	RestAssured.get(" http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/posts");
			
			int code = resp.getStatusCode();
			
			Assert.assertEquals(code, 200);
			
		}
		
		@Test
		public void resource_Posts_Put() {
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/json");
			
			JSONObject json = new JSONObject();
			//json.put("id", "2011");
			json.put("userId", "Updated 2011");
			json.put("body", "This is the Sujit's body Edited(updated)");
			json.put("title", "This is Sujit's Title Edited(updated) ");
			request.body(json.toJSONString());
			Response response = request.put(" http://ec2-54-84-52-184.compute-1.amazonaws.com:3000/posts/6178439");
					int code = response.getStatusCode();
			
			Assert.assertEquals(code, 200);
					
		}
		
		
		
	}

	
	
	

