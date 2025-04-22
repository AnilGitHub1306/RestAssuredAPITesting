package HttpsMethods;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.internal.net.http.common.Log;

public class DeleteRequest {

	String idNumber;
	@Test
	public void creatUser() {

		JSONObject json = new JSONObject();
        json.put("email", "Shreyash@gmail.com");
        json.put("first_name", "Shreyash");
        json.put("last_name", "Adhav");
        json.put("avatar", "https://reqres.in/img/faces/10-image.jpg");
		
		
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://reqres.in/api/users");
		requestSpe.header("Content-Type","application/json");
		requestSpe.contentType(ContentType.JSON);
		requestSpe.body(json.toJSONString());
		Response response = requestSpe.when().post();
		
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.jsonPath().getString("id"));	
	}
	
	@Test (priority=2)
	public void DeleteUserMethod() {

	    System.out.println(idNumber);
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://reqres.in/api/users"+idNumber);
		
		Response response = requestSpe.when().delete();
		
		System.out.println(response.getStatusCode());
		
	}
}
