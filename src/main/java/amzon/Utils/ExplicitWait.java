package amzon.Utils;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	public WebDriver driver;
	public static WebDriverWait webDriverWait;
	public static Wait<WebDriver> fluentWait;

	public ExplicitWait(WebDriver driver) {
		this.driver = driver;
		ExplicitWait.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		this.fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
	}

	// Wait for an element to be both present in the DOM and visible, and also
	// enabled and clickable.
	public static WebElement waitForElementToBeClickable(WebElement element) {
		return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Fluent wait for an element to be clickable with custom timeout and polling
	// interval.
	public static WebElement fluentWaitForElementToBeClickable(WebElement element, int timeoutInSeconds,
			int pollingIntervalInMillis) {
		return fluentWait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
