package pomPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebdriverUtility;

public class AddressFormPage {
	
	 
	//Declaration

	@FindBy (id="Name")
	private WebElement nameTF;

	@FindBy(id="House/Office Info")         
	private WebElement houseInfoTF; 

	@FindBy(id="Street Info")
	private WebElement streetInfoTF;

	@FindBy(id="Landmark")
    private WebElement landmarkTF;

    @FindBy (id="Country")
    private WebElement countryDropdown;

	@FindBy(id="State")
	private WebElement stateDropdown;
	
	@FindBy(id="City")
	private WebElement cityDropdown;
	
	@FindBy(id="Pincode")
	private WebElement pincodeTF;

	@FindBy (id="Phone Number")
	private WebElement phoneNumberTF;

	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddressButton;

//Initialization

    public AddressFormPage(WebDriver driver) {
	PageFactory.initElements (driver, this);

}

//Utilization

public void addAddressDetails(WebdriverUtility web, String name, String houseInfo,String street,String landmark,String country,String state,String city,String pincode,String phoneNum) {
		
	nameTF.sendKeys (name);
    houseInfoTF.sendKeys (houseInfo);
    streetInfoTF.sendKeys (street); 
    landmarkTF.sendKeys (landmark);

    web.selectFromDropdown (country, countryDropdown); 
    web.selectFromDropdown (state, addAddressButton);
    web.selectFromDropdown (city, cityDropdown);

    pincodeTF.sendKeys (pincode); 
    phoneNumberTF.sendKeys (phoneNum); 
    addAddressButton.click();
}

public void addAddressDetails(WebdriverUtility webUtil, Map<String, String> map) {
	// TODO Auto-generated method stub
	
}
}

