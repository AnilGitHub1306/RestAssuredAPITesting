package PayloadWithRequest;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class By3_PojoClass {

	@Test
	public void creatUser() {

		PojoClass pojObject = new PojoClass();
		pojObject.setEmail("Anil@gmail.com");
		pojObject.setFirst_name("Anil");
		pojObject.setLast_name("Adhav");
		pojObject.setAvatar("https://reqres.in/img/faces/10-image.jpg");
		

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://reqres.in/api/users");
		requestSpe.header("x-api-key", "reqres-free-v1");
		requestSpe.header("Content-Type","application/Json");
		requestSpe.contentType(ContentType.JSON);
		requestSpe.body(pojObject);
	
		Response response = requestSpe.when().post();
		
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
