package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.PageObjectManager;
import pageObjects.SearchPageLocators;
import utils.TestContextSetup;

public class SearchPageStepDefinition {
	
	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	public SearchPageLocators searchPageLocators;
	
	public SearchPageStepDefinition(TestContextSetup testContextSetup){
		this.testContextSetup = testContextSetup;
		this.searchPageLocators = testContextSetup.pageObjectManager.getSearchPageObject();
	}

	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() throws IOException {
		testContextSetup.testBase.webDriverManager();
	}
	
	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
		
		searchPageLocators.searchProduct(shortname);
		
		Thread.sleep(3000);
		testContextSetup.homePageProductName = searchPageLocators.getProductName().split("-")[0].trim();
		System.out.println("Product name extracted from home page: "+testContextSetup.homePageProductName);
	}
	
	@When("user added {string} items to cart")
	public void user_added_items_to_cart(String quantity)
	{
		searchPageLocators.incrementQuantity(Integer.parseInt(quantity));
		searchPageLocators.addToCartMethod();
	}
}
