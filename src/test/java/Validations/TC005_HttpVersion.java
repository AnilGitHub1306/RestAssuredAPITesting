package Validations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class TC005_HttpVersion {


	@Test
	public void validateTheHttpVersionOfResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		String expectedHttpVersion = "HTTP/1.1";
		boolean actualHttpVersion = response.getStatusLine().contains(expectedHttpVersion);

		System.out.println(response.getStatusLine());
		Assert.assertTrue(actualHttpVersion);
	}
	
	@Test
	public void validateTheHttpVersionOfResponse_ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		ResponseSpecification validateRes = requestSpe.then();
		validateRes.statusLine(containsString("HTTP/1.1"));
	}
	
	@Test
	public void validateTheHttpVersionOfResponse_BddStyle() {

		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.statusLine(containsString("HTTP/1.1"));
	}
}
