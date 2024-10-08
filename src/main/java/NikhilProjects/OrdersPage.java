package NikhilProjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {
	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productTitles;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement gotocheckout;

	public Boolean verifyOrderDisplay(String productname) {
		Boolean match = productTitles.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productname));
		return match;

	}

  

}
