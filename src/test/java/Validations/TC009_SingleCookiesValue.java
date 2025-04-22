package Validations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class TC009_SingleCookiesValue {

	@Test
	public void SingleCookiesValue() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");
		System.out.println(response.getCookie("sails.sid"));
	}
	

	@Test
	public void SingleCookiesValue__ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://httpbin.org/cookies/set?freeform=xyz123");
		
		ResponseSpecification validateRes = requestSpe.then();
		System.out.println(validateRes.cookie("freeform","xyz123"));
	}
	
	@Test
	public void SingleCookiesValue__BddStyle() {

		given()
		
		.when()
			.get("https://httpbin.org/cookies/set?freeform=xyz123")
			
		.then()
			.cookie("freeform","xyz123");
	}

}
