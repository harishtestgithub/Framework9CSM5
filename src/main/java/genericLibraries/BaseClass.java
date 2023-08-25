package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddressFormPage;
import pomPages.CartPage;
import pomPages.HeadPhonesPage;
import pomPages.HomePage;
import pomPages.MyAddressPage;
import pomPages.MyProfilePage;
import pomPages.ShopperLoginPage;
import pomPages.SignUpPage;
import pomPages.WelcomePage;

public class BaseClass {

	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebdriverUtility webUtil;
	public WebDriver driver;
	public static WebDriver sdriver;
	protected WelcomePage welcome;
	protected ShopperLoginPage login;
	protected HomePage home;
	protected SignUpPage signUp;
	protected MyProfilePage myProfile;
	protected MyAddressPage myAddress;
	protected HeadPhonesPage headphone;
	protected CartPage cart;
	protected AddressFormPage address;
	
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	public void classConfiguration() {
		property=new PropertiesUtility();
		excel=new ExcelUtility();
		jutil=new JavaUtility();
		webUtil=new WebdriverUtility();
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
	}
	@BeforeMethod
	public void methodConfiguration() {
		driver=webUtil.navigaToApp(property.getData("Browser"),property.getData("url"),Long.parseLong(property.getData("time")));
	    sdriver=driver;
	    login=new ShopperLoginPage(driver);
	    home=new HomePage(driver);
	    signUp=new SignUpPage(driver);
	    myProfile=new MyProfilePage(driver);
	    myAddress=new MyAddressPage(driver);
	    headphone=new HeadPhonesPage(driver);
	    cart=new CartPage(driver);
	    address=new AddressFormPage(driver);
	}
	@AfterMethod
	public void methodTeardown() {
		home.clickProfileButton();
		home.clicklogout();
		webUtil.closeAllBrowser();
	}

	@AfterClass
	public void  classTeardown() {
		
	}
}
