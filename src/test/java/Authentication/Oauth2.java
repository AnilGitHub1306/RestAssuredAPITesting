package Authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Oauth2 {

	public static void getAccessToken() {
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.formParam("grant_type", "client_credentials");
		requestSpec.formParam("client_id", "your_client_id");
		requestSpec.formParam("client_secret", "your_client_secret");
		Response response1 = requestSpec.post("https://your-auth-server.com/oauth/token");
		String token = response1.jsonPath().getString("access_token");

		requestSpec.header("Content-Type", "application/json");
		requestSpec.auth().oauth2(token); // Step 2: Set OAuth2 token

		Response response = requestSpec.when().get("https://api.yourservice.com/v1/yourendpoint");

		System.out.println(response.getBody().asPrettyString());
	}
}
