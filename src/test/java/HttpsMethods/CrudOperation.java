package HttpsMethods;

import java.util.Date;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CrudOperation {

	public static String id;
	public static String email;

	@Test
	public void creatUser() {

		email = new Date().toString().replace(" ", "").replace(":", "");

		JSONObject json = new JSONObject();
		json.put("name", "ANIL");
		json.put("email", "anil" + email + "@gmail.com");
		json.put("gender", "male");
		json.put("status", "inactive");

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://gorest.co.in/public/v2/users");
		requestSpe.header("Authorization", "Bearer 83654c156abeb4c350539bd0d85cb56efb8027812b557d2ae64f62a6a209731b");
		requestSpe.header("Content-Type", "application/json"); // Important!
		requestSpe.body(json.toJSONString());
		Response response = requestSpe.when().post();

		System.out.println(response.asPrettyString());

		id = response.jsonPath().getString("id");
		System.out.println("CREATE Method id : " + id);
	}

	@Test(dependsOnMethods = { "creatUser" })
	public void getUser() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://gorest.co.in/public/v2/users/" + id);
		requestSpe.header("Authorization", "Bearer 83654c156abeb4c350539bd0d85cb56efb8027812b557d2ae64f62a6a209731b");
		requestSpe.header("Content-Type", "application/json");

		Response response = requestSpe.when().get();

		// First print the full response to see
		System.out.println(response.asPrettyString());

		// Then capture the ID
		String fetchedId = response.jsonPath().getString("id");
		System.out.println("GET Method id : " + fetchedId);

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(dependsOnMethods = { "getUser" })
	public void updateUser() {

		JSONObject json = new JSONObject();
		json.put("name", "ANIL");
		json.put("email", "anil" + email + "@gmail.com");
		json.put("gender", "male");
		json.put("status", "active");

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://gorest.co.in/public/v2/users/" + id);
		requestSpe.header("Authorization", "Bearer 83654c156abeb4c350539bd0d85cb56efb8027812b557d2ae64f62a6a209731b");
		requestSpe.header("Content-Type", "application/json"); // Important!
		requestSpe.body(json.toJSONString());
		Response response = requestSpe.when().put();

		System.out.println(response.asPrettyString());

		System.out.println("UPDATE Method id : " + response.jsonPath().getString("id"));
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(dependsOnMethods = { "updateUser" })
	public void deleteUser() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://gorest.co.in/public/v2/users/" + id);
		requestSpe.header("Authorization", "Bearer 83654c156abeb4c350539bd0d85cb56efb8027812b557d2ae64f62a6a209731b");
		requestSpe.header("Content-Type", "application/json"); // Important!
		Response response = requestSpe.when().delete();
	
		Assert.assertEquals(response.getStatusCode(), 204);

	}
}
