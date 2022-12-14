package wealus.TestNGFrameworkDevelopment.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import wealus.TestNGFrameworkDevelopment.abstractComponents.AbstractComponent;

public class OrderConfirmationPage extends AbstractComponent {

	public WebDriver d;

	public OrderConfirmationPage(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(className = "hero-primary")
	WebElement successMessage;

	public void verifySuccessMessage(String successMessageInput) {

		String successMessageText = successMessage.getText();
		Assert.assertEquals(successMessageText, successMessageInput);
	}

}
