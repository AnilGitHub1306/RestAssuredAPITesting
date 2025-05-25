package PayloadWithRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class By1_JSONObject {

	@Test
	public void creatUser() {

		JSONObject json = new JSONObject();
        json.put("email", "Anil@gmail.com");
        json.put("first_name", "Anil");
        json.put("last_name", "Adhav");
        json.put("avatar", "https://reqres.in/img/faces/10-image.jpg");
		
		
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://reqres.in/api/users");
		requestSpe.header("x-api-key", "reqres-free-v1");
		requestSpe.header("Content-Type","application/Json");
		requestSpe.contentType(ContentType.JSON);
		requestSpe.body(json.toJSONString());
	
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
	
	@Test
	public void creatUser1() {

		Faker fakeData = new Faker();
		String email = fakeData.internet().safeEmailAddress();
		String firstName = fakeData.name().firstName();
		String lastName = fakeData.name().lastName();
			String a= "https://reqres.in/img/faces/";
			int randomNum =	(int) (Math.random() * (100 - 1   + 1)) + 1;
			String b = "-image.jpg";
		String avatar = a+randomNum + b;
		
		JSONObject json = new JSONObject();
        json.put("email", email);
        json.put("first_name", firstName);
        json.put("last_name", lastName);
        json.put("avatar", avatar);
		
		
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://reqres.in/api/users");
		requestSpe.header("x-api-key", "reqres-free-v1");
		requestSpe.header("Content-Type","application/Json");
		requestSpe.contentType(ContentType.JSON);
		requestSpe.body(json.toJSONString());
	
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
