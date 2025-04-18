package Validations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_StatusLine {

	@Test
	public void validateTheStatusLine() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		String expectedStatusLine = "HTTP/1.1 200 OK";
		String actualStatusLine = response.getStatusLine();
	//	System.out.println(actualStatusLine);
		
		Assert.assertEquals(expectedStatusLine, actualStatusLine);

	}
}
