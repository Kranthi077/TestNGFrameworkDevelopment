package wealus.TestNGFrameworkDevelopment.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wealus.TestNGFrameworkDevelopment.abstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {

	public WebDriver d;

	public LoginPage(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}

	// WebElement userName1 = d.findElement(By.id("userEmail"));
	// PageFactory Model
	@FindBy(id = "userEmail")
	WebElement userName;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement loginButton;

	public void loginToApplication(String userNameInput, String passwordInput) {

		userName.sendKeys(userNameInput);
		password.sendKeys(passwordInput);
		loginButton.click();
	}

	public void launchUrl() {
		d.get("https://rahulshettyacademy.com/client");
	}

}
