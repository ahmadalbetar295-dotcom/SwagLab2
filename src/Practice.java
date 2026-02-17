
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice {
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
	public void addAllItemsToCart() {

		List<WebElement> addAllItem = driver.findElements(By.className("btn_primary"));
		List<WebElement> theNamesItem = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> allPrices = driver.findElements(By.className("inventory_item_price"));

		
		for (int i = 0; i < addAllItem.size(); i++) {
			if(i % 2 == 0 ) {
				addAllItem.get(i).click();
				System.out.println(
						theNamesItem.get(i).getText() + " has been added the price is "+ allPrices.get(i).getText());
			}
			else {System.out.println(
					theNamesItem.get(i).getText() + " has not been added the price is "+ allPrices.get(i).getText());
				
				
			}
	}

	}
}


