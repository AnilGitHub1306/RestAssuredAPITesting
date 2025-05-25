package Headers;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SingleHeaderInRequest {

	@Test
	public void singleHeaderWithRequest() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://reqres.in/api/users");

		requestSpe.queryParam("page", "2");
		requestSpe.header("Content-type", "application/json");
		Response response = requestSpe.when().get();
		
		System.out.println(response.asPrettyString());
		
		System.out.println("getStatusCode : "+response.getStatusCode());
		System.out.println("getStatusLine : "+response.getStatusLine());
		System.out.println("getTime : "+response.getTime());
		System.out.println("getHeader 'Content-Type' : "+response.getHeader("Content-Type"));
		System.out.println("getHeaders : "+response.getHeaders());
		System.out.println("getCookies : "+response.getCookies());
		System.out.println("getBody : "+response.getBody().asString());
	}
}
