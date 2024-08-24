package NikhilProjects.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import NikhilProjects.testComponenets.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test()
	public void LoginErrorValidation() throws IOException {

//		String productname = "ZARA COAT 3";
//		String countryname = "India";

		landingpage.loginApplication("abcdabcdsfef@abc.com", "Password@123");
		
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrormsg());

	}

}
