package wealus.TestNGFrameworkDevelopment.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wealus.TestNGFrameworkDevelopment.abstractComponents.AbstractComponent;

public class PaymentMethodPage extends AbstractComponent {

	public WebDriver d;

	public PaymentMethodPage(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}

	// PageFactory Model

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryTextArea;

	@FindBy(className = "ta-item")
	List<WebElement> countryList;

	@FindBy(className = "action__submit")
	WebElement placeOrderButton;

	public void selectCountry(String countryInput) {

		countryTextArea.sendKeys(countryInput);
		for (WebElement country : countryList) {
			if (country.getText().equalsIgnoreCase(countryInput)) {
				country.click();
				break;
			}
		}

	}

	public void clickPlaceOrder() {
		waitForWebElementToAppear(placeOrderButton);
		placeOrderButton.click();

	}

}
