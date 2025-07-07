package Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Oauth2 {

	public static void getAccessToken() {
		//Step1 :  Get the access token
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.formParam("grant_type", "client_credentials");
		requestSpec.formParam("client_id", "your_client_id");
		requestSpec.formParam("client_secret", "your_client_secret");
		Response preResponse = requestSpec.post("https://your-auth-server.com/oauth/token");
		
		String token = preResponse.jsonPath().getString("access_token");
		requestSpec.header("Content-Type", "application/json");
		
		// Step 2: Set OAuth2 token
		requestSpec.auth().oauth2(token); 
		Response response = requestSpec.when().get("https://api.yourservice.com/v1/yourendpoint");
		System.out.println(response.getBody().asPrettyString());
	}
}
