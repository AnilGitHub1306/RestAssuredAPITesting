package Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Digest {
	
	@Test
	public void digestAuthentication()
	{
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.header("Content-Type","application/json");
		requestSpe.auth().digest("admin", "admin123");
		Response response = requestSpe.when().get("https://httpbin.org/digest-auth/undefined/admin/admin123");
		
		System.out.println(response.getBody().asPrettyString());	
	}

}
