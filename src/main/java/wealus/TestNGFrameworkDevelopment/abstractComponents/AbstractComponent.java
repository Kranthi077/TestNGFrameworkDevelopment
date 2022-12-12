package wealus.TestNGFrameworkDevelopment.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//this class contains all the functions/methods common to any testcase
public class AbstractComponent {

	public WebDriver d;

	public AbstractComponent(WebDriver d) {
		this.d = d;
	}

	WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(15));

	public void waitForElementToAppear(By selector) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
	}

	public void waitForWebElementToAppear(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public void waitForElementToDisappear(By selector) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
	}



}
