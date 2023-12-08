package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageObjects.OffersPageLocators;
import pageObjects.PageObjectManager;
import pageObjects.SearchPageLocators;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	SearchPageLocators searchPageLocators;
	OffersPageLocators offersPageLocators;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^user searched (.+) shortname in offers page$")
	public void user_searched_shortname_in_offers_page(String shortname) throws InterruptedException {
		
		offersPageLocators = testContextSetup.pageObjectManager.getOffersPageObject();
		Thread.sleep(3000);
		
		switchToOffersPage();
		offersPageLocators.searchProductOnOffersPage(shortname);
		Thread.sleep(3000);
		
		testContextSetup.offerPageProductName = offersPageLocators.getProductNameOnOffersPage();
		System.out.println("Product name extracted from offers page: "+testContextSetup.offerPageProductName);
	}

	public void switchToOffersPage()
	{
		searchPageLocators = testContextSetup.pageObjectManager.getSearchPageObject();
		searchPageLocators.topDealsOnSearchPage();
		testContextSetup.genericUtils.switchToOtherWindow();
	}
	
	@Then("Validate product name matches with landing page")
	public void validate_product_name_matches_with_landing_page() {
		Assert.assertEquals(testContextSetup.offerPageProductName, testContextSetup.homePageProductName);
	}
	
}
