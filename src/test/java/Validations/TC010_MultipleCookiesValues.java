package Validations;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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
}
