package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPageLocators {

    WebDriver driver;
	
	public OffersPageLocators(WebDriver driver)
	{
		this.driver = driver;
	}

	public By searchProductOnOffersPage = By.xpath("//input[@type='search']");
	public By productNameOnOffersPage = By.xpath("//td[1]");
	
	public void searchProductOnOffersPage(String name) 
	{
		driver.findElement(searchProductOnOffersPage).sendKeys(name);
	}
	
	public String getProductNameOnOffersPage()
	{
		return driver.findElement(productNameOnOffersPage).getText();
	}
	
}
