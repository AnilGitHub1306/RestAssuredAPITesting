package Validations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC004_StatusCodeText {

	@Test
	public void validateTheHttpVersionOfResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		String expectedHttpVersion = "HTTP/1.1";
		boolean actualHttpVersion = response.getStatusLine().contains(expectedHttpVersion);

		System.out.println(response.getStatusLine());
		Assert.assertTrue(actualHttpVersion);

	}
}
