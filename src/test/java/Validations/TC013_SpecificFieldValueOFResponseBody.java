package Validations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class TC013_SpecificFieldValueOFResponseBody {

	@Test
	public void ValidateTheWholeResponseBody() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");

	//	String expectedResponseBody = "{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces/7-image.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":\"https://reqres.in/img/faces/11-image.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image.jpg\"}],\"support\":{\"url\":\"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral\",\"text\":\"Tired of writing endless social media content? Let Content Caddy generate it for you.\"}}";
		JsonPath jsonRresponseBody  = response.getBody().jsonPath();
		System.out.println(response.asPrettyString());

		Assert.assertEquals(jsonRresponseBody.get("data[3].first_name"), "Byron");
		
	}
	
	@Test
	public void SpecificFieldValueOFResponseBody__ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");
		
		ResponseSpecification validateRes = requestSpe.then();
		
		validateRes.body(containsString("Janet")); 				// Checks if "Janet" exists in full response body
		validateRes.body("data[3].first_name", equalTo("Byron")); 	// Validate text
	}
	
	@Test
	public void SpecificFieldValueOFResponseBody__BddStyle() {

		given()
		.queryParam("page", "2")
		
		.when()
			.get("https://reqres.in/api/users")
			
		.then()
			.body("data[3].first_name", equalTo("Byron")); 	// Validate text
	}
}
