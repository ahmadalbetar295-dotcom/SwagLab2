import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();

	@BeforeTest

	public void mySetupTest() {
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void login() {
		// Elements
		WebElement InputUserNameField = driver.findElement(By.id("user-name"));

		WebElement InputPasswordField = driver.findElement(By.id("password"));

		WebElement LoginButton = driver.findElement(By.id("login-button"));

		// Actions
		InputUserNameField.sendKeys("standard_user");

		InputPasswordField.sendKeys("secret_sauce");

		LoginButton.click();

	}

	@Test(priority = 2)
	public void addToCart() {
		// Elements

		WebElement FirstItem = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
		WebElement SecondItem = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));

		// Actions
		FirstItem.click();
		SecondItem.click();

	}

	@Test(priority = 3, enabled = true)
	public void RemoveItems() throws InterruptedException {
		Thread.sleep(3000);

		WebElement FirstItem = driver.findElement(By.id("remove-sauce-labs-bike-light"));
		FirstItem.click();
		WebElement SecondItem = driver.findElement(By.id("remove-sauce-labs-fleece-jacket"));
		SecondItem.click();

	}

	@Test(priority = 4, enabled = true)
	public void AddAfterRemove() {
		// Elements

		WebElement FirstItem = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
		WebElement SecondItem = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));

		// Actions
		FirstItem.click();
		SecondItem.click();
	}

	@Test(priority = 5, enabled = true)
	public void CheckOut() throws InterruptedException {

		// WebElement CartContainerButton = driver.findElement(By.id("shopping_cart_container"));
		// CartContainerButton.click();
		//driver.navigate().to("https://www.saucedemo.com/cart.html");
		WebElement CartContainerButton = driver.findElement(By.className("shopping_cart_container"));
		CartContainerButton.click();

		WebElement CheckoutButton = driver.findElement(By.id("checkout"));
		CheckoutButton.click();

		WebElement FirstName = driver.findElement(By.id("first-name"));

		WebElement SecondName = driver.findElement(By.id("last-name"));

		WebElement PostalCode = driver.findElement(By.id("postal-code"));

		FirstName.sendKeys("Ahmad");

		SecondName.sendKeys("Albetar");

		PostalCode.sendKeys("21111");

		WebElement ContinueButton = driver.findElement(By.name("continue"));

		ContinueButton.click();

		WebElement FinishButton = driver.findElement(By.name("finish"));

		FinishButton.click();

		WebElement BackToHomeButton = driver.findElement(By.id("back-to-products"));

		BackToHomeButton.click();

	}

	@Test(priority = 6, enabled = true)
	public void logOut() throws InterruptedException {
		WebElement BurgerMenu = driver.findElement(By.id("react-burger-menu-btn"));

		BurgerMenu.click();

		Thread.sleep(2000);

		WebElement LogOutButton = driver.findElement(By.id("logout_sidebar_link"));

		LogOutButton.click();

	}

	@AfterTest(enabled = true)
	public void AfterTestDone() {
		driver.close();
//		

	}
}
