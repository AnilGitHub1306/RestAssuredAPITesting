package HttpsMethods;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@Test
	public void creatUser() {

		JSONObject json = new JSONObject();
        json.put("email", "Anil@gmail.com");
        json.put("first_name", "Anil");
        json.put("last_name", "Adhav");
        json.put("avatar", "https://reqres.in/img/faces/10-image.jpg");
		
		
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://reqres.in/api/users");
		requestSpe.header("Content-Type","application/Json");
		requestSpe.contentType(ContentType.JSON);
	
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
