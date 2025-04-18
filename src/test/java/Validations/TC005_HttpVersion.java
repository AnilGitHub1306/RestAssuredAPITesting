package Validations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC005_HttpVersion {

	@Test
	public void validateTheStatusCodeText() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		String expectedStatusCodeText = "OK";
		boolean actualStatusCodeText = response.getStatusLine().contains(expectedStatusCodeText);

		Assert.assertTrue(actualStatusCodeText);

	}
}
