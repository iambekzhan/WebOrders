package pomdesign;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.WebOrdersLoginPage;
import utilities.Config;
import utilities.Driver;

public class WebOrdersLoginTests {
	
	WebDriver driver;
	String url = "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx";
	String user = "Tester";
	String psw = "test";
	
	@BeforeClass
	public void setup() {
		driver = Driver.getDriver();
	}
	
//	@Ignore
	@Test (enabled = false)
	public void positiveLoginTest() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(Config.getValue("username"));
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(Config.getValue("password") + Keys.ENTER);
//		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	}
	
	@Test (priority = 1, enabled = true)
	public void positiveLoginTestUsingPOM() {
		WebOrdersLoginPage loginPage = new WebOrdersLoginPage(driver);
		driver.get(Config.getValue("url"));
//		loginPage.userName.sendKeys(user);
//		loginPage.password.sendKeys(psw + Keys.ENTER);
		loginPage.login(Config.getValue("username"), Config.getValue("password"));
//		loginPage.loginBtn.click();
	}
	
	@Test (priority = 2, enabled = true)
	public void invalidUserNameOrPasswordTest() {
		driver.get(url);
		WebOrdersLoginPage loginPage = new WebOrdersLoginPage(driver);
		loginPage.login("invalid", "test");
		
		String actualInvalidText = loginPage.invalidUserNameErrMsg.getText();
		String expectedInvalidText = "Invalid Login or Password.";
		Assert.assertEquals(actualInvalidText, expectedInvalidText);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
