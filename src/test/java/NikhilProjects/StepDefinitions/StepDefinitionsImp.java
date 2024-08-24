package NikhilProjects.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import NikhilProjects.CartPage;
import NikhilProjects.CheckOutPage;
import NikhilProjects.ConfirmationPage;
import NikhilProjects.LandingPage;
import NikhilProjects.ProductCatelogue;
import NikhilProjects.testComponenets.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsImp extends BaseTest {

	LandingPage landingpage;
	ProductCatelogue p;
	CartPage cartpage;
	ConfirmationPage confirmationpage;
	String countryname = "India";

	@Given("I Landed on the E-commerce page")
	public void I_Landed_on_the_Ecommerce_page() throws IOException {
		landingpage = launchApp();
	}

	@Given("logged in to the E-commerce application with user name {string} and password {string}")
	public void LoggedIn_With_Username_Password(String uname, String pass) {
		p = landingpage.loginApplication(uname, pass);
	}

	@When("Adding the product {string} to the cart")
	public void adding_Product_To_Cart(String product) {
		p.addToCart(product);
	}

	@When("Checkout the product {string} place the order")
	public void Checkout_the_product(String product) {
		cartpage = p.goToCart();

		Boolean match = cartpage.verifyProductDisplay(product);
		Assert.assertTrue(match);

		CheckOutPage checkout = cartpage.goToCheckout();

		confirmationpage = checkout.PlaceOrder(countryname);

	}

	@Then("confirmation message {string} visible")
	public void confirmation_message_visible(String string) {
		String messege = confirmationpage.getConfirmation();
		Assert.assertTrue(messege.equalsIgnoreCase(string));
		driver.close();
	}

	@Then("{string} message is displayed")
	public void message_Is_Displayed(String messaage) {
		landingpage.loginApplication("abcdabcdsfef@abc.com", "Password@123");

		Assert.assertEquals(messaage, landingpage.getErrormsg());
		driver.close();
	}

}