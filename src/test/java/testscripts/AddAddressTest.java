package testscripts;

import java.util.Map;

import org.testng.Assert;

import genericLibraries.BaseClass;
import pomPages.WelcomePage;

public class AddAddressTest extends BaseClass{
		public AddAddressTest() throws InterruptedException{

	   Map<String , String> map = excel.getData("Sheet1", "Add Address");
	   WelcomePage.clickloginButton();
	   login.loginToApp(map.get("Email"),map.get("Password"));
	   Thread.sleep(2000);
	   home.clickProfileButton();
	   Thread.sleep(2000);
	   home.selectMyProfile();
	   Thread.sleep(2000);
	   myProfile.clickMyAddresses();
	   myAddress.clickAddAddress();
	   address.addAddressDetails(webUtil,map);
	   Thread.sleep(2000);
	   Assert.assertEquals(myAddress.getSuccessMessage(), "successfully added");
	   Thread.sleep(5000);
	   
		}
	}


