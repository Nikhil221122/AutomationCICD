package AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import NikhilProjects.CartPage;
import NikhilProjects.OrdersPage;

public class AbstractComponent {

	WebDriver driver;
	
	@FindBy(css="button[routerlink=\"/dashboard/cart\"]")
	WebElement cartheader;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitForElementToDisAppear(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.invisibilityOf(element));

	}
	
	public CartPage goToCart() {
		cartheader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	public OrdersPage goToOrderPage() {
		orderHeader.click();
		OrdersPage orderspage = new OrdersPage(driver);
		return orderspage;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
