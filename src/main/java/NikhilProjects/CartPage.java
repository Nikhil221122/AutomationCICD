package NikhilProjects;
//Importing Packages
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cart h3")
	List<WebElement> productTitles;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement gotocheckout;

	public Boolean verifyProductDisplay(String productname) {
		Boolean match = productTitles.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productname));
		return match;

	}

	public CheckOutPage goToCheckout() {
		gotocheckout.click();
		CheckOutPage checkout = new CheckOutPage(driver);
		return checkout;
	}

}
