package SerilizationAndDeserilization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import groovy.transform.ASTTest;

public class Serilization {
	
	@Test
	public void convertClassObjectToJsonData() throws JsonProcessingException {
		
		Faker fakeData = new Faker();
		
		String firstName = fakeData.name().firstName();
		String lastName = fakeData.name().lastName();
		String email = fakeData.internet().safeEmailAddress();
			String a= "https://reqres.in/img/faces/";
			int randomNum =	(int) (Math.random() * (100 - 1   + 1)) + 1;
			String b = "-image.jpg";
		String avatar = a+randomNum + b;
		
		PojoClass pojoObject = new PojoClass();
		pojoObject.setFirst_name(firstName);
		pojoObject.setLast_name(lastName);
		pojoObject.setEmail(email);
		pojoObject.setAvatar(avatar);
		
		ObjectMapper objMap = new ObjectMapper();
		String data = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(pojoObject);
		
		System.out.println(data.toString());
	
	}

}
