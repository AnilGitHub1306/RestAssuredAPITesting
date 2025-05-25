package Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiKey {
	
	@Test
	public void apiKeyAuthentication()
	{
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.header("Content-Type","application/json");
		requestSpe.header("Authorization","ofFxrwQK4e4TkwRf9gtKkaq8Z4RibGaoD5G3PDzFcnVOIsnVhAkXRWS8");
	
		Response response = requestSpe.when().get("https://api.pexels.com/v1/search?query=people");
		
		System.out.println(response.getBody().asPrettyString());	
	}
}
