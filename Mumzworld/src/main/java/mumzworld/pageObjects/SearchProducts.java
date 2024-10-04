package mumzworld.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

//import Mumzworld.ProductDetails;

public class SearchProducts {
	WebDriver driver;

	public SearchProducts(WebDriver driver) {
		// super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@aria-label,'Gear')]")
	WebElement GearSection;

	@FindBy(xpath = "//*[@id=\"root\"]/main/div[2]/article/div[3]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div[7]")
	WebElement SelectStrollers;

	@FindBy(xpath = "//div[contains(@class,'gallery-items')]/div/a")
	List<WebElement> StrollerItems;

	@FindBy(xpath = "//*[@id='root']/main/div[2]/article/div[3]/div[2]/section/div/div/div[1]/a[@title]")
	WebElement ItemOpen;

	@FindBy(className = "algoliaSearchBox-input-1IL")
	WebElement Search;

	@FindBy(xpath = "//button[@title ='Submit your search query']")
	WebElement Searchbtn;

	@FindBy(xpath = "//div[@class='algoliaSearchContent-items-3GO gallery-items-2G-']/div/a")
	List<WebElement> ProductList;

	@FindBy(xpath = "//*[@id='root']/main/div[2]/article/div[2]/div[2]/section[1]/div/div/div[1]/a")
	WebElement OpenProduct;

	@FindBy(xpath = "//div[contains(@class,'algoliaSearchBar')]/h3")
	WebElement SearchResult;

	public void SelectGearSectionAnClickStroller() throws InterruptedException {
		GearSection.click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@id='root']/main/div[2]/article/div[3]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div[7]")));
		SelectStrollers.click();

	}

	public List<WebElement> StrollerNames() {
		return StrollerItems;

	}

	public void ItemSelection() {
		ItemOpen.click();

	}

	public void ScrollIntoRecommendedStrollers() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class,'gallery-items')]/div/a")));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");

		// js.executeScript("document")
		// return driver;
	}

	public void SearchProduct() throws InterruptedException {
		Search.sendKeys("rattle toy");
		Thread.sleep(3000);
		Assert.assertEquals("Top Results", SearchResult.getText());
		Searchbtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='algoliaSearchContent-items-3GO gallery-items-2G-']/div/a")));

	}

	public List<WebElement> ProductNames() {
		return ProductList;

	}

	public void OpenSearchProduct() {
		OpenProduct.click();

	}

}
