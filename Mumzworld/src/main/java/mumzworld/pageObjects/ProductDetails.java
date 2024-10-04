package mumzworld.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {

	WebDriver driver;

	public ProductDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Add To Wishlist']")
	WebElement WishListbutton;

	@FindBy(xpath = "//button[@title='Add to bag']")
	WebElement Bag;

	@FindBy(xpath = "//a[@title='View Bag']")
	WebElement BagView;

	@FindBy(xpath = "//div[@class= 'feedbackPopup-message-1GV']/span[2]")
	WebElement Successful;

	public CartPage WishlistButtonClick() {
		WishListbutton.click();
		return new CartPage(driver);
	}

	public void ShoppingBag() {
		Bag.click();

	}

	public String SuccessfullyAddedToBag() {
		return Successful.getText();
	}

	public CartPage ViewBag() {
		BagView.click();
		return new CartPage(driver);
	}

}
