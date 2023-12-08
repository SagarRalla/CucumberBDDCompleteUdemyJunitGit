package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public SearchPageLocators searchPageLocators;
	public OffersPageLocators offersPageLocators;
	public CheckoutPageLocators checkoutPageLocators;
	
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}

	public SearchPageLocators getSearchPageObject()
	{
		searchPageLocators = new SearchPageLocators(driver);
		return searchPageLocators;
	}
	
	public OffersPageLocators getOffersPageObject()
	{
		offersPageLocators = new OffersPageLocators(driver);
		return offersPageLocators;
	}
	
	public CheckoutPageLocators getCheckoutPageObject()
	{
		checkoutPageLocators = new CheckoutPageLocators(driver);
		return checkoutPageLocators;
	}
}
