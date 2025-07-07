package Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basic {
	
	@Test
	public void basicAuthentication()
	{
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.header("Content-Type","application/json");
		
		requestSpe.auth().preemptive().basic("postman", "password");
		
		Response response = requestSpe.when().get("http://postman-echo.com/basic-auth");
		
		System.out.println(response.getBody().asPrettyString());	
	}

}
