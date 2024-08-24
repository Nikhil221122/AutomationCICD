package NikhilProjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductCatelogue extends AbstractComponent{
	WebDriver driver;
	
	public ProductCatelogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
 
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement  spinner;
	By productsBy  = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(" .card-body button:last-of-type");
	
	 public List<WebElement> getProductList() {
		 waitForElementToAppear(productsBy);
		 return products;
	 }
	 
	 public WebElement getProductByName(String productName) {
		 WebElement product = products.stream().filter(s->s.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		return product;
	 }
	
	public void addToCart( String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(By.cssSelector("#toast-container"));
		waitForElementToDisAppear(spinner);
		
	}
	
}
