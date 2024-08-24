package NikhilProjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement countryName;

	@FindBy(css = ".ta-item")
	List<WebElement> results;

	@FindBy(css = ".action__submit")
	 WebElement  Submit;
	
	
	public ConfirmationPage PlaceOrder(String countryname) {
		
		countryName.sendKeys(countryname);
		results.stream().filter(s->s.getText().equalsIgnoreCase(countryname)).forEach(s->s.click());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Submit);
		ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		return confirmationpage;
				
	}


}
