package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPageLocators;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckOutPageStepDefinition {
	
	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	public CheckoutPageLocators checkoutPageLocators;
	
	public CheckOutPageStepDefinition(TestContextSetup testContextSetup){
		this.testContextSetup = testContextSetup;
		this.checkoutPageLocators = testContextSetup.pageObjectManager.getCheckoutPageObject();
	}

	@Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException
	{
		checkoutPageLocators.checkOutItems();
		Thread.sleep(3000);
	}
	
	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order()
	{
		Assert.assertTrue(checkoutPageLocators.verifyPromoButton());
		Assert.assertTrue(checkoutPageLocators.verifyPlaceOrder());
	}
	
}
