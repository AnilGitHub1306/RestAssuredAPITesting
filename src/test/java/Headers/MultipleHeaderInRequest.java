package Headers;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MultipleHeaderInRequest {

	@Test
	public void multipleHeaderWithRequestMethod1() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://reqres.in/api/users");

		requestSpe.queryParam("page", "2");
		requestSpe.header("Content-type", "application/json");
		requestSpe.header("x-api-key", "reqres-free-v1");
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
	
	@Test
	public void multipleHeaderWithRequestByHashMap() {

		HashMap<String, String> headers = new HashMap<>();
		headers.put("Content-type", "application/json");
		headers.put("x-api-key", "reqres-free-v1");
		
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://reqres.in/api/users");
		requestSpe.queryParam("page", "2");
		requestSpe.headers(headers);
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
