package Validations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
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
	
	@Test
	public void validateTheSizeOfTheResponseData_ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		ResponseSpecification validateRes = requestSpe.then();
		validateRes.body("data.size()", equalTo(6));
	}
	
	@Test
	public void validateTheSizeOfTheResponseData_BddStyle() {

		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.body("data.size()", equalTo(6));
	}
}
