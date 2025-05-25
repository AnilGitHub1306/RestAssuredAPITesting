package PayloadWithRequest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class By4_ExternalFile {

	@Test
	public void creatUser() throws Throwable {
		File f= new File(System.getProperty("user.dir")+"/FileData.json");
		FileReader frRead = new FileReader(f);
		JSONTokener jt = new JSONTokener(frRead);
		JSONObject js = new JSONObject(jt);
		
		
		RequestSpecification requestSpe = RestAssured.given();
		requestSpe.baseUri("https://reqres.in/api/users");
		requestSpe.header("x-api-key", "reqres-free-v1");
		requestSpe.header("Content-Type","application/Json");
		requestSpe.contentType(ContentType.JSON);
		requestSpe.body(js.toString());
	
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
