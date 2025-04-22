package Validations;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class TC003_ResponseTime {

	@Test
	public void validateTheResponseTime() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");

		long actualStatusTime = response.getTimeIn(TimeUnit.SECONDS);
		System.out.println(actualStatusTime);
		
		if (actualStatusTime <= 5) 
			{Assert.assertTrue(true);} 
		else 
			{Assert.assertTrue(false);}
	}
	
	@Test
	public void validateTheResponseTime_ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		ResponseSpecification validateRes = requestSpe.then();
		validateRes.time(lessThan(2000L));
	}
	
	@Test
	public void validateTheResponseTime_BddStyle() {

		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.time(lessThan(2000L));
	}
}
