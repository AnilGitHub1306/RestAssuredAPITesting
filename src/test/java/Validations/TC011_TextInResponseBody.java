package Validations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class TC011_TextInResponseBody {

	@Test
	public void ValidateTheTextInResponseBody() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");

		String ResponseBodyinStringFormate = response.getBody().asString();
		System.out.println(ResponseBodyinStringFormate);

		boolean status = ResponseBodyinStringFormate.contains("Byron");
		Assert.assertTrue(status);
		System.out.println(status + " : Byron name avainble in response body");

	}

	@Test
	public void ValidateTheTextInResponseJsonBody() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");

		JsonPath jsonResponseBody = response.jsonPath();
		List<String> firstNameList = jsonResponseBody.getList("data.first_name");

		boolean status = false;
		for (String firstName : firstNameList) {
			System.out.println(firstName);
			if (firstName.equals("Byron")) {
				Assert.assertTrue(true);
				status = true;
			}
		}
		System.out.println(status);
		Assert.assertTrue(status);
	}
	
	@Test
	public void ValidateTheTextInResponseBody__ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");
		
		ResponseSpecification validateRes = requestSpe.then();
		
		validateRes.body(containsString("Janet")); 				// Checks if "Janet" exists in full response body
		validateRes.body("data.first_name", equalTo("Janet")); 	// Validate text
	}
	
	@Test
	public void ValidateTheTextInResponseBody__BddStyle() {

		given()
		.queryParam("page", "2")
		.when()
			.get("https://reqres.in/api/users")
			
		.then()
			.body("data.first_name", equalTo("Janet")); 	// Validate text
	}
}
