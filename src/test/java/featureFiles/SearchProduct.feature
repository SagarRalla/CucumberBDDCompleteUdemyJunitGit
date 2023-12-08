Feature: Search and place the order for the product

@OfferPage
Scenario Outline: Search product in both home and offers page

	Given User is on GreenCart landing page
	When user searched with shortname <Name> and extracted actual name of product 
	Then user searched <Name> shortname in offers page 
	And Validate product name matches with landing page

Examples:
	|Name|
	|tom|
	|beet|