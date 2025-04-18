package Validations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC006_SizeOfData {

	@Test
	public void validateTheSizeOfTheResponseData() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");

		int expectedSizeOfTheResponseData = 2000;
		int actualSizeOfTheResponseData = response.asByteArray().length;
		System.out.println(actualSizeOfTheResponseData);
		
		if(expectedSizeOfTheResponseData>=actualSizeOfTheResponseData)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	

	}
}
