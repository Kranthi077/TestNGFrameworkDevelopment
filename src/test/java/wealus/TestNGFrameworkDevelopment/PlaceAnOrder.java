package wealus.TestNGFrameworkDevelopment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import wealus.TestNGFrameworkDevelopment.pageObjects.CartPage;
import wealus.TestNGFrameworkDevelopment.pageObjects.LoginPage;
import wealus.TestNGFrameworkDevelopment.pageObjects.OrderConfirmationPage;
import wealus.TestNGFrameworkDevelopment.pageObjects.PaymentMethodPage;
import wealus.TestNGFrameworkDevelopment.pageObjects.ProductsDashboadPage;

public class PlaceAnOrder {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String expectedProductName = "IPHONE 13 PRO";
		LoginPage loginPage = new LoginPage(d);
		loginPage.launchUrl();
		loginPage.loginToApplication("welcome@gmail.com", "Welcome@123");

		ProductsDashboadPage productsDashboadPage = new ProductsDashboadPage(d);
		productsDashboadPage.clickOnProduct(expectedProductName);
		productsDashboadPage.verifyToastMessage();
		productsDashboadPage.goToCartPage();

		CartPage cartPage = new CartPage(d);
		cartPage.findProductAndClickBuyNow(expectedProductName);

		PaymentMethodPage paymentMethodPage = new PaymentMethodPage(d);
		paymentMethodPage.selectCountry("India");
		paymentMethodPage.clickPlaceOrder();

		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(d);
		orderConfirmationPage.verifySuccessMessage("THANKYOU FOR THE ORDER.");

		d.close();

	}

}
