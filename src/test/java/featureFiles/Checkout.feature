Feature: Place the order for the product

@PlaceOrder
Scenario Outline: Search product and place the order

	Given User is on GreenCart landing page
	When user searched with shortname <Name> and extracted actual name of product 
	And user added "3" items to cart
	Then user proceeds to checkout and validate the <Name> items in checkout page
	And verify user has ability to enter promo code and place the order

Examples:
	|Name|
	|tom|