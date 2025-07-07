package Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiKey {
	
	@Test
	public void apiKeyAuthentication()
	{
		//https://api.example.com/data?api_key=YOUR_API_KEY
		
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("api_key", "YOUR_API_KEY_HERE");
		requestSpe.header("Content-Type","application/json");
			
		Response response = requestSpe.when().get("https://api.example.com/data");
		
		System.out.println(response.getBody().asPrettyString());	
	}
}
