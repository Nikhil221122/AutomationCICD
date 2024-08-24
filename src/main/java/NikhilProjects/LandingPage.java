package NikhilProjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement userEmail = driver.findElement(By.id("userEmail"));
//	Page Factory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	 
	public ProductCatelogue loginApplication(String email,String pass) {
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		login.click();
		ProductCatelogue p = new ProductCatelogue(driver);
		return p;
	}
	
	public String getErrormsg() {
		waitForWebElementToAppear(errorMessage);
		 
		return errorMessage.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
	
}
