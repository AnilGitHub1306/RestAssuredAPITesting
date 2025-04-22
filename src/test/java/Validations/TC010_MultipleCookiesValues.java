package Validations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class TC010_MultipleCookiesValues {

	@Test
	public void MultipleCookiesValues() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");

		// Capturing the cookies in Map
		Map<String, String> cookiespair = response.getCookies();

		// Getting key set of cookies
		Set<String> cookies = cookiespair.keySet();
		for (String cookie : cookies) 
		{
			System.out.print(cookie + " :- ");
			System.out.println(response.getCookie(cookie));
		}

	}
	
	@Test
	public void MultipleCookiesValues__ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://httpbin.org/cookies/set?freeform=xyz123");
		
		ResponseSpecification validateRes = requestSpe.then();
		
		validateRes.cookies("SESSIONID", equalTo("abc123"),
							"UserToken", equalTo("xyz789"));
	}
	
	@Test
	public void MultipleCookiesValues__BddStyle() {

		given()
		
		.when()
			.get("https://httpbin.org/cookies/set?freeform=xyz123")
			
		.then()
			.cookies("SESSIONID", equalTo("abc123"),
					"UserToken", equalTo("xyz789"));
	}
}
