package Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken {
	
	@Test
	public void bearerTokenAuthentication()
	{
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.header("Content-Type","application/json");
		requestSpe.header("Authorization", "Bearer abcdefghijkl1234567890");
		Response response = requestSpe.when().get("https://httpbin.org/bearer");
		
		System.out.println(response.getBody().asPrettyString());	
	}

}
