package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//table[@class='ProductsTable']//tr/td[1]")
	public List<WebElement> productNames;
	
	@FindBy (xpath = "//table[@class='ProductsTable']//tr")
	public List<WebElement> productRows;
	
}
