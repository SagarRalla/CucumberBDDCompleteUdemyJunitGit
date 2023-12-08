package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageLocators {

	public WebDriver driver;
	
	public CheckoutPageLocators(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By cartBag = By.xpath("//a[@class='cart-icon']");
	By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoButton = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	
	public void checkOutItems() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public Boolean verifyPromoButton()
	{
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public Boolean verifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}

}
