package PayloadWithRequest;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class DummyDataByFakerClass {
	
	@Test
	public void generateDummyData() {
		
		Faker fakeData = new Faker();
		String email = fakeData.internet().safeEmailAddress();
		String firstName = fakeData.name().firstName();
		String lastName = fakeData.name().lastName();
			String a= "https://reqres.in/img/faces/";
			int randomNum =	(int) (Math.random() * (100 - 1   + 1)) + 1;
			String b = "-image.jpg";
		String avatar = a+randomNum + b;
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);
		System.out.println(avatar);
	}

}
