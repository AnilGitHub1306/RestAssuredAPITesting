package Validations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class TC007_SingleHeaderValue {

	
	
	@Test
	public void validateTheSingleHeaderValue() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");

		Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");
	}
	
	@Test
	public void validateTheSingleHeaderValue_ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		ResponseSpecification validateRes = requestSpe.then();
		validateRes.header("Content-Type", "application/json; charset=utf-8");
	}
	
	@Test
	public void validateTheSingleHeaderValue_BddStyle() {

		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.header("Content-Type", "application/json; charset=utf-8");
	}

}
