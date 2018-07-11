package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrdersLoginPage {
	
//	WebDriver driver;
	
	public WebOrdersLoginPage(WebDriver driver) {
//		this.driver = driver;
		// using the driver initialize or locate all elements in this class
		PageFactory.initElements(driver, this);
	}
	
	// Using @FindBy specify way to locate the WebElement
	@FindBy(id = "ctl00_MainContent_username")
	public WebElement userName;
	
	@FindBy(id = "ctl00_MainContent_password")
	public WebElement password;
	
	@FindBy(id = "ctl00_MainContent_login_button")
	public WebElement loginBtn;
	
	@FindBy(id = "ctl00_MainContent_status")
	public WebElement invalidUserNameErrMsg;
	
	public void login(String usr, String pass) {
		userName.sendKeys(usr);
		password.sendKeys(pass + Keys.ENTER);
	}
	
	
	
}
