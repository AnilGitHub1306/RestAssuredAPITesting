package Validations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC007_SingleHeaderValue {

	
	
	@Test
	public void validateTheSingleHeaderValue() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");

		Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");

	}

}
