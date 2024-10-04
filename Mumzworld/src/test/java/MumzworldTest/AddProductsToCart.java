package MumzworldTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Mumzworld.BaseClass.BaseTest;
import mumzworld.pageObjects.SearchProducts;
import mumzworld.pageObjects.CartPage;
import mumzworld.pageObjects.ProductDetails;
import mumzworld.pageObjects.Registration;

public class AddProductsToCart extends BaseTest {
		 
	final String productName= "Little Angel - Baby Toys Hanging Rattle Soft Toy - Elephant - Ivory";
	@Test
	public void AddProductAndCheckout() throws InterruptedException {
		// INITIALIZE DRIVER AND LAUNCH THE WEBSTORE
		initializeDriver();
		LaunchMumzworldApp();
        Assert.assertTrue(driver.getTitle().contains("#1 Mother, Child & Baby Shop in the UAE - Mumzworld"), "Failed to open Mumzworld webstore."); //Assert to check the title is correct for the webstore
		Thread.sleep(5000);
		

		//SEARCH PRODUCT AND DYNAMICALLY SELECT AN ITEM FROM A LIST
		SearchProducts selectProducts = new SearchProducts(driver);
		selectProducts.SearchProduct();
		List<WebElement> SearchProductNames = selectProducts.ProductNames();
		for (int j = 0; j < SearchProductNames.size(); j++) {
			String SelectProductToWishList = SearchProductNames.get(j).getAttribute("title");
			if (SelectProductToWishList
					.equalsIgnoreCase(productName)) {
				selectProducts.OpenSearchProduct();
				break;
			}

		}
		

		// GOTO CART PAGE
		ProductDetails productDetailsPage = new ProductDetails(driver);
		productDetailsPage.ShoppingBag();
		Assert.assertEquals("Successfully added to bag", productDetailsPage.SuccessfullyAddedToBag());
		productDetailsPage.ViewBag();
		Thread.sleep(2000);
		Assert.assertEquals("Cart - English", driver.getTitle()); //Assert to check if we have reached the Cart page
		
		

		// INCREASE QUANTIT OF PRODUCT TO 5
		CartPage cart = new CartPage(driver);
		Assert.assertEquals(productName, cart.CheckProductName()); //Assert to check that the same product is added in the cart as selected from search
		for (int i = 0; i <= 5; i++) {
			cart.Increasebtn();
			break;
		}
		
		
		// Register A New User From Checkout Page
		Registration register = cart.ProceedToCheckoutPage();
		register.RegisterNewUser();
		Assert.assertEquals("Create an Account - English", driver.getTitle()); //Assert to check if we have reached the register page
		
		
		

//EXTRA TEST CASE TO DYNAMICALLY SELECT PRODUCT FROM GEAR SECTION

		// selectProducts.SelectGearSectionAnClickStroller();
		// selectProducts.ScrollIntoRecommendedStrollers();
		// selectProducts.SearchProduct();
		// List<WebElement> StrollerList = selectProducts.StrollerNames();
		// for (int i = 0; i < StrollerList.size(); i++) {
		// String SelectStroller = StrollerList.get(i).getAttribute("title");
		// if (SelectStroller.equalsIgnoreCase("Teknum - SLD Travel Lite Stroller -
		// Black")) {
		// selectProducts.ItemSelection();
		// }
		// }

	}
}
