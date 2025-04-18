package Validations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
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
}
