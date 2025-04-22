package Validations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class TC004_StatusCodeText {

	@Test
	public void validateTheStatusCodeText() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		String expectedStatusCodeText = "OK";
		boolean actualStatusCodeText = response.getStatusLine().contains(expectedStatusCodeText);

		Assert.assertTrue(actualStatusCodeText);
	}
	
	@Test
	public void validateTheStatusCodeText_ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		ResponseSpecification validateRes = requestSpe.then();
		validateRes.statusLine(containsString("OK"));
	}
	
	@Test
	public void validateTheStatusCodeText_BddStyle() {

		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.statusLine(containsString("OK"));
	}
}
