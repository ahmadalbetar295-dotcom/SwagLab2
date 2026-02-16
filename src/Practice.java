
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
		driver.findElements(By.className("btn.btn_primary.btn_small.btn_inventory"));
//		static
		String[] mynames = { "ahmad ", "sara", "leen", "mohmmad" };
		System.out.println(mynames.length);

		// dynamic

//		List<WebElement> prices = new ArrayList<WebElement>();
//		WebElement firstItemPrice = driver.findElement(By.className("inventory_item_price"));
//		prices.add(firstItemPrice);
//		System.out.println(prices.get(0).getText());
		List<WebElement> allPrices = driver.findElements(By.className("inventory_item_price"));
		System.out.println(allPrices.get(5).getText());

		for (int i = 0; i < allPrices.size(); i++) {
			System.out.println(allPrices.get(i).getText());
		}
		List<WebElement> addAllItem = driver.findElements(By.className("btn_primary"));

		for (int i = 0; i < addAllItem.size(); i++) {
			
			if(i==3 || i==4) {
				System.out.println("this item has been skipped");
//				break;
				 continue;
			}
			addAllItem.get(i).click();
		}

	}

}
