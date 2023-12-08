package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPageLocators {
	
	WebDriver driver;
	
	public SearchPageLocators(WebDriver driver)
	{
		this.driver = driver;
	}

	public By searchProduct = By.xpath("//input[@type='search']");
	public By productName = By.xpath("//h4[@class='product-name']");
	public By topDeals = By.linkText("Top Deals");
	public By increment = By.cssSelector("a.increment");
	public By addToCart = By.cssSelector(".product-action button");
	
	public void searchProduct(String name) 
	{
		driver.findElement(searchProduct).sendKeys(name);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public void topDealsOnSearchPage()
	{
		driver.findElement(By.linkText("Top Deals")).click();
	}
	
	public void incrementQuantity(int quantity)
	{
		int i = quantity-1;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
	}
	
	public void addToCartMethod()
	{
		driver.findElement(addToCart).click();
	}
}
