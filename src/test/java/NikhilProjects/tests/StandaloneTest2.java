package NikhilProjects.tests;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
public class StandaloneTest2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/");
		
		String productname = "ZARA COAT 3";
		String countryname = "India";
		
		driver.findElement(By.id("userEmail")).sendKeys("abcdabcd@abc.com");
		driver.findElement(By.id("userPassword")).sendKeys("Password@123");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> elements = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement product = elements.stream().filter(s->s.findElement(By.tagName("b")).getText().equals(productname)).findFirst().orElse(null);
		product.findElement(By.cssSelector(" .card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink=\"/dashboard/cart\"]")).click();
		
		List<WebElement> Cartproducts = driver.findElements(By.cssSelector(".cart h3"));
		Boolean match = Cartproducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		
		driver.findElement(By.xpath("//button[text()=\"Checkout\"]")).click();
	
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("india");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));

		List<WebElement> country = driver.findElements(By.cssSelector(".ta-item"));
		
		country.stream().filter(s->s.getText().equalsIgnoreCase(countryname)).forEach(s->s.click());
		WebElement Submit = driver.findElement(By.cssSelector(".action__submit"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", Submit);
		
		
		String Confirmedmesege = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(Confirmedmesege.equalsIgnoreCase("Thankyou for the order."));
		driver.quit();
	}

}
