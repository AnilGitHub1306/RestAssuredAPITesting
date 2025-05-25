package SerilizationAndDeserilization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import groovy.transform.ASTTest;

public class Deserilization {
	
	@Test
	public void convertJsonDataToClassObject() throws JsonProcessingException {
		
	String JsonData = "{\r\n"
			+ "  \"email\" : \"dianna.cronin@example.com\",\r\n"
			+ "  \"first_name\" : \"Roscoe\",\r\n"
			+ "  \"last_name\" : \"Goyette\",\r\n"
			+ "  \"avatar\" : \"https://reqres.in/img/faces/75-image.jpg\"\r\n"
			+ "}";
		
			
		ObjectMapper objMap = new ObjectMapper();
		PojoClass pojoObj = objMap.readValue(JsonData, PojoClass.class);
		
		System.out.println(pojoObj.getFirst_name());
		System.out.println(pojoObj.getLast_name());
		System.out.println(pojoObj.getEmail());
		System.out.println(pojoObj.getAvatar());
	
	}

}
