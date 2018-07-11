package pomdesign;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AllOrdersPage;
import pages.ProductsPage;
import pages.WebOrdersLoginPage;
import utilities.Config;
import utilities.Driver;

public class WebOrderTests {
	
	WebDriver driver;
	WebOrdersLoginPage loginPage;
	AllOrdersPage allOrdersPage;
	ProductsPage productsPage;
	String user = Config.getValue("username");
	String pass = Config.getValue("password");
	
	@BeforeClass
	public void setup() {
		driver = Driver.getDriver();
	}
	
	@BeforeMethod
	public void setUpApplication() {
		driver.get(Config.getValue("url"));
		loginPage = new WebOrdersLoginPage(driver);
	}
	
	@Test (description = "Verify labels and tab links are displayed", priority = 1)
	public void labelsVerification() {
		assertEquals(driver.getTitle(), "Web Orders Login", "LoginPage is not displayed. Application is down");
		loginPage.login(user, pass);
		
		allOrdersPage = new AllOrdersPage(driver);
		assertTrue(allOrdersPage.webOrders.isDisplayed(), "Web Orders is not displayed");
		assertTrue(allOrdersPage.listOfAllOrders.isDisplayed(), "List of All Orders label is not displayed");
		assertEquals(allOrdersPage.welcomeMsg.getText().replace(" | Logout", ""), "Welcome, " + user + "!");
		assertTrue(allOrdersPage.viewAllOrders.isDisplayed(), "View All Orders tab is not displayed");
		assertTrue(allOrdersPage.viewAllProducts.isDisplayed(), "View All Products tab is not displayed");
		assertTrue(allOrdersPage.orderTab.isDisplayed(), "Order tab is not displayed");
	}
	
	/*
	 * 		Step 1. Navigate to loginpage
	 * 		Step 2. Assert that you are on loginpage
	 * 		Step 3. Login using valid credentials
	 * 		Step 4. Click on view all products
	 * 		Step 5. Verify following products are displayed:
	 * 				MyMoney
	 * 				FamilyAlbum
	 * 				ScreenSaver
	 * 		
	 * 		Step 6.	Verify prices and discounts:
	 * 				MyMoney			$100 	8%
	 * 				FamilyAlbum		$80		15%
	 * 				ScreenSaver		$20		10%
	 */
	
	@Test (description = "Verify default Products and Prices", priority = 2)
	public void availableProductsTest() {
		assertEquals(driver.getTitle(), "Web Orders Login", "LoginPage is not displayed. Application is down");
		loginPage.login(user, pass);
		
		allOrdersPage = new AllOrdersPage(driver);
		allOrdersPage.viewAllProducts.click();
		
		productsPage = new ProductsPage(driver);
		
		List<String> expProducts = Arrays.asList("MyMoney", "FamilyAlbum", "ScreenSaver");
		List<String> actProducts = new ArrayList<>();
		
//		productsPage.productNames.forEach(elem -> actProducts.add(elem.getText()));
		for(WebElement prod : productsPage.productNames) {
			actProducts.add(prod.getText());
		}
		
		assertEquals(actProducts, expProducts, "Our default products is not same with our expected");
		
		for(WebElement row : productsPage.productRows) {
//			System.out.println(row.getText());
			String[] prodData = row.getText().split(" ");
			
			switch(prodData[0]) {
				case "MyMoney":
					assertEquals(prodData[1], "$100");
					assertEquals(prodData[2], "8%");
					break;
				case "FamilyAlbum":
					assertEquals(prodData[1], "$80");
					assertEquals(prodData[2], "15%");
					break;
				case "ScreenSaver":
					assertEquals(prodData[1], "$20");
					assertEquals(prodData[2], "10%");
					break;
			}
			
		}
	}
	
	@AfterMethod
	public void logout() {
		allOrdersPage.logout();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
