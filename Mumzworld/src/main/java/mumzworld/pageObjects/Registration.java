package mumzworld.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {

	WebDriver driver;

	public Registration(WebDriver driver) {
		// super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "(//button[contains(text(),'Register')])[1]")
//	WebElement Register;

	@FindBy(xpath = "//button[@title='Sign up']")
	WebElement Signup;

	@FindBy(id = "create_account_page_firstname")
	WebElement NameFirst;

	@FindBy(id = "create_account_page_lastname")
	WebElement NameLast;

	@FindBy(id = "create_account_page_email")
	WebElement Email;

	@FindBy(id = "create_account_page_password")
	WebElement Password;

	@FindBy(xpath = "//button[contains(@class,'submitButton')]")
	WebElement RegisterButton;

	public void RegisterNewUser() {
		// Register.click();
		Signup.click();
		NameFirst.sendKeys("Dell");
		NameLast.sendKeys("Sharma");
		Email.sendKeys("deesharma01@gmail.com");
		Password.sendKeys("deeS@011");
		RegisterButton.click();

	}

}
