package NikhilProjects.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NikhilProjects.CartPage;
import NikhilProjects.CheckOutPage;
import NikhilProjects.ConfirmationPage;
import NikhilProjects.OrdersPage;
import NikhilProjects.ProductCatelogue;
import NikhilProjects.testComponenets.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String productname = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = "Purchase")
	public void submitOrder(HashMap<String,String>input) throws IOException {

		String countryname = "India";

		ProductCatelogue p = landingpage.loginApplication(input.get("email"), input.get("pass"));

		p.addToCart(input.get("product"));
		CartPage cartpage = p.goToCart();

		Boolean match = cartpage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);

		CheckOutPage checkout = cartpage.goToCheckout();

		ConfirmationPage confirmationpage = checkout.PlaceOrder(countryname);
		String messege = confirmationpage.getConfirmation();
		Assert.assertTrue(messege.equalsIgnoreCase("Thankyou for the order."));
	}

	@Test(dependsOnMethods = "submitOrder")
	public void OrderHistoryTest() {
		ProductCatelogue p = landingpage.loginApplication("abcdabcd@abc.com", "Password@123");
		OrdersPage orderspage = p.goToOrderPage();
		Assert.assertTrue(orderspage.verifyOrderDisplay(productname));

	}

	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String,String> map = new HashMap<String,String>();
// 		map.put("email","abcdabcd@abc.com"); 
// 		map.put("pass","Password@123");
// 		map.put("product", "ZARA COAT 3");
// 		
// 		HashMap<String,String> map1 = new HashMap<String,String>();
// 		map1.put("email","xyzxyz@xyz.com"); 
// 		map1.put("pass","Password@123");
// 		map1.put("product", "ADIDAS ORIGINAL");
		
		
		List<HashMap<String,String>> data = getJasonDataTOMap(System.getProperty("user.dir")+"\\src\\test\\java\\NikhilProjects\\data\\PurchaseOrder.json");
 		return new Object[][] {{data.get(0)},{data.get(1)}};
 		
 		
//		return new Object[][]{{"abcdabcd@abc.com","Password@123","ZARA COAT 3"},{"xyzxyz@xyz.com","Password@123","ADIDAS ORIGINAL"}};
	}
}
