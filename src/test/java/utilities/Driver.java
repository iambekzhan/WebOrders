package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver != null) {
			return driver;
		}
//		System.setProperty("webdriver.chrome.driver", "/Users/iambekzhan/Documents/Selenium/Drivers/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		return driver;
	}
}
