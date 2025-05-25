package PayloadWithRequest;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class By2_HashMap {

	@Test
	public void creatUser() {

		
		HashMap hm = new HashMap();
		hm.put("email", "Anil@gmail.com");
		hm.put("first_name", "Anil");
		hm.put("last_name", "Adhav");
		hm.put("avatar", "https://reqres.in/img/faces/10-image.jpg");
		
		
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://reqres.in/api/users");
		requestSpe.header("x-api-key", "reqres-free-v1");
		requestSpe.header("Content-Type","application/Json");
		requestSpe.contentType(ContentType.JSON);
		requestSpe.body(hm);
	
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
		
		HashMap hm = new HashMap();
		hm.put("email", email);
		hm.put("first_name", firstName);
		hm.put("last_name", lastName);
		hm.put("avatar", avatar);
		
		
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://reqres.in/api/users");
		requestSpe.header("x-api-key", "reqres-free-v1");
		requestSpe.header("Content-Type","application/Json");
		requestSpe.contentType(ContentType.JSON);
		requestSpe.body(hm);
	
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
