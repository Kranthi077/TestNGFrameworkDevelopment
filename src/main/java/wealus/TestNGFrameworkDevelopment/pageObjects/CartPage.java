package wealus.TestNGFrameworkDevelopment.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wealus.TestNGFrameworkDevelopment.abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	public WebDriver d;

	public CartPage(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}

	// PageFactory Model

	@FindBy(xpath = "//div[@class='infoWrap']")
	List<WebElement> cartProducts;

	By actualCartProductText = By.tagName("h3");
	By buyNowButton = By.className("btn-primary");

	public void findProductAndClickBuyNow(String expectedProductName) {
		for (WebElement cartProduct : cartProducts) {
			String actualCartProduct = cartProduct.findElement(actualCartProductText).getText();
			if (actualCartProduct.equalsIgnoreCase(expectedProductName)) {
				cartProduct.findElement(buyNowButton).click();
				break;
			}

		}

	}

}
