package Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Oauth1 {

	public static void getAccessToken() 
	{
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret");
		Response response = requestSpec.when().get("https://api.yourservice.com/v1/yourendpoint");

		System.out.println(response.getBody().asPrettyString());
	}
}
