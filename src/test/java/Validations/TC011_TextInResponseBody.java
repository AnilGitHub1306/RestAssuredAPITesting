package Validations;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC011_TextInResponseBody {

	@Test
	public void ValidateTheTextInResponseBody() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");

		String ResponseBodyinStringFormate = response.getBody().asString();
		System.out.println(ResponseBodyinStringFormate);

		boolean status = ResponseBodyinStringFormate.contains("Byron");
		Assert.assertTrue(status);
		System.out.println(status + " : Byron name avainble in response body");

	}
}
