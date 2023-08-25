package testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pomPages.WelcomePage;

public class AddToCartTest extends  BaseClass {

	@Test
	public void addAddressTest() throws InterruptedException{
		Map<String,String> map = excel.getData("Sheet1", "Add To Cart");
		WelcomePage.clickloginButton();
		login.loginToApp(map.get("Email"),map.get("Password"));
		Thread.sleep(2000);
		home.mouseHoverToElectronic(webUtil);
		Thread.sleep(3000);
		home.clickHeadPhonesLink();
		headphone.clickAddToCart();
		Thread.sleep(3000);
		Assert.assertEquals(headphone.getAddToCartText(), "ADDED");
		String itemName = headphone.getItemName();
		headphone.getcarticon();
		Assert.assertTrue(cart.getCartItem().equalsIgnoreCase(itemName));
		
		
		
		
	}

}
