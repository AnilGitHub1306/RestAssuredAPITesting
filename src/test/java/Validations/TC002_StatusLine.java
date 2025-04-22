package Validations;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class TC002_StatusLine {

	@Test
	public void validateTheStatusLine() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		String expectedStatusLine = "HTTP/1.1 200 OK";
		String actualStatusLine = response.getStatusLine();
		Assert.assertEquals(expectedStatusLine, actualStatusLine);
	}
	
	@Test
	public void validateTheStatusLine_ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		ResponseSpecification validateRes = requestSpe.then();
		validateRes.statusLine("HTTP/1.1 200 OK");
	}
	
	@Test
	public void validateTheStatusLine_BddStyle() {

		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.statusLine("HTTP/1.1 200 OK");
	}
}
