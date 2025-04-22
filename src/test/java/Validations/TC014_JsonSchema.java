package Validations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class TC014_JsonSchema {

	public String jsonSchema ="{\r\n"
			+ "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\r\n"
			+ "  \"title\": \"Generated schema for Root\",\r\n"
			+ "  \"type\": \"object\",\r\n"
			+ "  \"properties\": {\r\n"
			+ "    \"page\": {\r\n"
			+ "      \"type\": \"number\"\r\n"
			+ "    },\r\n"
			+ "    \"per_page\": {\r\n"
			+ "      \"type\": \"number\"\r\n"
			+ "    },\r\n"
			+ "    \"total\": {\r\n"
			+ "      \"type\": \"number\"\r\n"
			+ "    },\r\n"
			+ "    \"total_pages\": {\r\n"
			+ "      \"type\": \"number\"\r\n"
			+ "    },\r\n"
			+ "    \"data\": {\r\n"
			+ "      \"type\": \"array\",\r\n"
			+ "      \"items\": {\r\n"
			+ "        \"type\": \"object\",\r\n"
			+ "        \"properties\": {\r\n"
			+ "          \"id\": {\r\n"
			+ "            \"type\": \"number\"\r\n"
			+ "          },\r\n"
			+ "          \"email\": {\r\n"
			+ "            \"type\": \"string\"\r\n"
			+ "          },\r\n"
			+ "          \"first_name\": {\r\n"
			+ "            \"type\": \"string\"\r\n"
			+ "          },\r\n"
			+ "          \"last_name\": {\r\n"
			+ "            \"type\": \"string\"\r\n"
			+ "          },\r\n"
			+ "          \"avatar\": {\r\n"
			+ "            \"type\": \"string\"\r\n"
			+ "          }\r\n"
			+ "        },\r\n"
			+ "        \"required\": [\r\n"
			+ "          \"id\",\r\n"
			+ "          \"email\",\r\n"
			+ "          \"first_name\",\r\n"
			+ "          \"last_name\",\r\n"
			+ "          \"avatar\"\r\n"
			+ "        ]\r\n"
			+ "      }\r\n"
			+ "    },\r\n"
			+ "    \"support\": {\r\n"
			+ "      \"type\": \"object\",\r\n"
			+ "      \"properties\": {\r\n"
			+ "        \"url\": {\r\n"
			+ "          \"type\": \"string\"\r\n"
			+ "        },\r\n"
			+ "        \"text\": {\r\n"
			+ "          \"type\": \"string\"\r\n"
			+ "        }\r\n"
			+ "      },\r\n"
			+ "      \"required\": [\r\n"
			+ "        \"url\",\r\n"
			+ "        \"text\"\r\n"
			+ "      ]\r\n"
			+ "    }\r\n"
			+ "  },\r\n"
			+ "  \"required\": [\r\n"
			+ "    \"page\",\r\n"
			+ "    \"per_page\",\r\n"
			+ "    \"total\",\r\n"
			+ "    \"total_pages\",\r\n"
			+ "    \"data\",\r\n"
			+ "    \"support\"\r\n"
			+ "  ]\r\n"
			+ "}";
	@Test
	public void ValidateTheWholeResponseBody() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");

		String expectedResponseBody = "{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces/7-image.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":\"https://reqres.in/img/faces/11-image.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image.jpg\"}],\"support\":{\"url\":\"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral\",\"text\":\"Tired of writing endless social media content? Let Content Caddy generate it for you.\"}}";
		String stringRresponseBody = response.getBody().asString();
		System.out.println(response.asPrettyString());

		boolean isValide = JsonSchemaValidator.matchesJsonSchema(jsonSchema).matches(stringRresponseBody);

		Assert.assertTrue(isValide);
	}
	
	@Test
	public void ValidateTheWholeResponseBody__ByValidatableResponse() {

		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.queryParam("page", "2");
		Response response = requestSpe.when().get("https://reqres.in/api/users");
		
		ResponseSpecification validateRes = requestSpe.then();
		
		validateRes.body(matchesJsonSchema(jsonSchema));
	}
	
	@Test
	public void ValidateTheWholeResponseBody__BddStyle() {

		given()
		.queryParam("page", "2")
		
		.when()
			.get("https://reqres.in/api/users")
			
		.then()
			.body(matchesJsonSchema(jsonSchema));
	}
}
