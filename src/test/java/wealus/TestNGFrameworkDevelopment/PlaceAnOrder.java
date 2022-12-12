package wealus.TestNGFrameworkDevelopment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.internal.junit.ExactComparisonCriteria;

import io.github.bonigarcia.wdm.WebDriverManager;
import wealus.TestNGFrameworkDevelopment.pageObjects.LoginPage;
import wealus.TestNGFrameworkDevelopment.pageObjects.ProductsDashboadPage;

public class PlaceAnOrder {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(15));
		String expectedProductName = "IPHONE 13 PRO";
		LoginPage loginPage = new LoginPage(d);
		loginPage.launchUrl();
		loginPage.loginToApplication("welcome@gmail.com", "Welcome@123");

		ProductsDashboadPage productsDashboadPage = new ProductsDashboadPage(d);
		productsDashboadPage.clickOnProduct(expectedProductName);
		productsDashboadPage.verifyToastMessage();
		
		
		d.findElement(By.xpath("//button[@routerlink=\"/dashboard/cart\"]")).click();

		List<WebElement> cartProducts = d.findElements(By.xpath("//div[@class=\"infoWrap\"]"));

		for (WebElement cartProduct : cartProducts) {
			String actualCartProduct = cartProduct.findElement(By.tagName("h3")).getText();
			if (actualCartProduct.equalsIgnoreCase(expectedProductName)) {
				cartProduct.findElement(By.className("btn-primary")).click();
				break;
			}

		}

		d.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");
		List<WebElement> countryList = d.findElements(By.className("ta-item"));
		for (WebElement country : countryList) {
			if (country.getText().equalsIgnoreCase("India")) {
				country.click();
				break;
			}
		}
		d.findElement(By.className("action__submit")).click();

		String successMessage = d.findElement(By.className("hero-primary")).getText();
		Assert.assertEquals(successMessage, "THANKYOU FOR THE ORDER.");
		d.close();

	}

}
