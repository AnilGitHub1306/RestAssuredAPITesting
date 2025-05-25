package Validations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_StatusCode {

	@Test
	public void validateTheStatusCode() {
	
		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		int expectedStatusCode = 200;
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(expectedStatusCode, actualStatusCode);
	}
	
	@Test
	public void validateTheStatusCode_ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");
		
		ValidatableResponse validateRes = response.then();
		validateRes.statusCode(200);
	}
	
	@Test
	public void validateTheStatusCode_BddStyle() {

		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.statusCode(200);
	}
}
