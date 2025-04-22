package HttpsMethods;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.internal.net.http.common.Log;

public class PatchRequest {

    // Store user ID between tests
    String userId;

    @Test(priority = 1)
    public void createUser() {
        JSONObject json = new JSONObject();
        json.put("email", "Shreyash@gmail.com");
        json.put("first_name", "Shreyash");
        json.put("last_name", "Adhav");
        json.put("avatar", "https://reqres.in/img/faces/10-image.jpg");

        RequestSpecification requestSpe = RestAssured.given();
        requestSpe.baseUri("https://reqres.in/api/users");
        requestSpe.header("Content-Type", "application/json");
        requestSpe.contentType(ContentType.JSON);
        requestSpe.body(json.toJSONString());

        Response response = requestSpe.when().post();

        System.out.println("Create Response:");
        System.out.println(response.asPrettyString());

        // Get user ID from response (it's a string in reqres.in)
        userId = response.jsonPath().getString("id");
        System.out.println("User ID: " + userId);
    }

    @Test(priority = 2, dependsOnMethods = {"createUser"})
    public void updateUserByPatchMethod() {
        JSONObject json1 = new JSONObject();
        json1.put("email", "Anil123@gmail.com");

        RequestSpecification requestSpe = RestAssured.given();
        requestSpe.baseUri("https://reqres.in/api/users/" + userId);
        requestSpe.header("Content-Type", "application/json");
        requestSpe.contentType(ContentType.JSON);
        requestSpe.body(json1.toJSONString());

        Response response = requestSpe.when().patch();

        System.out.println("Patch Response:");
        System.out.println(response.asPrettyString());
    }
}