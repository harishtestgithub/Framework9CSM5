package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	//Declaration
	@FindBy(id="loginBtn")
	private static WebElement loginButton;
	
	//Initialization
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	//Utilization
	public static void clickloginButton() {
		try {
			loginButton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
