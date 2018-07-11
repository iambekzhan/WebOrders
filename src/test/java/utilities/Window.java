package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class Window {
	
	public static Alert getAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	public static void switchToWindow(String title, WebDriver driver) {
		for(String window : driver.getWindowHandles() ) {
			driver.switchTo().window(window);
			if(driver.getTitle().equals(title)) {
				break;
			}
		}
	}
	
	public static void switchToSecondWindow(WebDriver driver) {
		String win = driver.getWindowHandle();
		for(String window : driver.getWindowHandles() ) {
			if(!window.equals(win)) {
				driver.switchTo().window(win);
				break;
			}
		}
	}
}
