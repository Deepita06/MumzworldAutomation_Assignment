package mumzworld.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		// super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[title='Wishlist']")
	WebElement Wishlist;

	@FindBy(css = "a[title='Cart']")
	WebElement Cart;

	@FindBy(xpath = "(//button[@aria-label=\"Increase Quantity\"])[2]")
	WebElement Increase;

	@FindBy(className = "proceedToCheckoutBtn-root-2ra")
	WebElement Checkout;

	@FindBy(xpath = "//input[@id='21700266']")
	WebElement qty;

	@FindBy(className = "product-productName-8VS")
	WebElement checkProduct;

	public void GoToWishlistPage() {
		Wishlist.click();
	}

	public void GoToCartPage() {
		Cart.click();
	}

	public void Increasebtn() {
		Increase.click();
	}

	public String CheckProductName() {
		return checkProduct.getText();
	}

	public String Quantity() {
		return qty.getAttribute("value").toString();
	}

	public Registration ProceedToCheckoutPage() {
		Checkout.click();
		return new Registration(driver);
	}

}
