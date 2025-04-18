package Validations;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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
}
