package wealus.TestNGFrameworkDevelopment.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wealus.TestNGFrameworkDevelopment.abstractComponents.AbstractComponent;

public class ProductsDashboadPage extends AbstractComponent {

	public WebDriver d;

	public ProductsDashboadPage(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}

	// PageFactory Model

	@FindBy(className = "col-lg-4")
	List<WebElement> products;

	By productName = By.tagName("h5");
	By addToCart = By.xpath(".//button[contains(@class,'w-10')]");

	By toastMessage = By.className("toast-message");

	public void clickOnProduct(String expectedProductName) {

		for (WebElement product : products) {
			String actualProductName = product.findElement(productName).getText();
			if (actualProductName.equalsIgnoreCase(expectedProductName)) {
				product.findElement(addToCart).click();
				break;
			}
		}

	}

	public void verifyToastMessage() {
		waitForElementToAppear(toastMessage);
	}



}
