package Validations;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class TC008_MultipleHeadersValue {

	@Test
	public void validateTheMultipleHeaders1() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");

		Headers headers1 = response.getHeaders();
		for (Header header : headers1) {
			if ((header.getName()).equalsIgnoreCase("Content-Type")) {
				Assert.assertEquals(header.getValue(), "application/json; charset=utf-8");
			} else if ((header.getName()).equalsIgnoreCase("Connection")) {
				Assert.assertEquals(header.getValue(), "keep-alive");
			} else if ((header.getName()).equalsIgnoreCase("Content-Encoding")) {
				Assert.assertEquals(header.getValue(), "gzip");
			}
		}
	}

	@Test
	public void validateTheMultipleHeader() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");
		
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");
		Assert.assertEquals(response.getHeader("Connection"), "keep-alive");
		Assert.assertEquals(response.getHeader("Content-Encoding"), "gzip");
	}

	@Test
	public void validateTheMultipleHeaders() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");

		String headerContentType = response.getHeader("Content-Type");
		String headerConnection = response.getHeader("Connection");
		String headerContentEncoding = response.getHeader("Content-Encoding");

		if (headerContentType.equals("application/json; charset=utf-8") && headerConnection.equals("keep-alive")
				&& headerContentEncoding.equals("gzip")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}
	
	@Test
	public void MultipleHeadersValue_ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		Response response = requestSpe.when().get("https://reqres.in/api/users?page=2");

		ResponseSpecification validateRes = requestSpe.then();
		validateRes.headers("Content-Type", "application/json; charset=utf-8",
		        			"Connection","keep-alive",
		        			"Content-Encoding","gzip");
	}
	
	@Test
	public void MultipleHeadersValue_BddStyle() {

		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.headers("Content-Type","application/json; charset=utf-8",	"Connection","keep-alive",	"Content-Encoding","gzip");
	}

}
