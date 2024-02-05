package amzon.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {

	WebDriver driver;
	private WebElement dropdownElement;
	static Select dropdown;

	public SelectDropdown(WebDriver driver) {
		this.driver = driver;
		dropdown = new Select(dropdownElement);
	}

	public static void selectByVisibleText(WebElement dropdownElement, String visibleText) {
		dropdown.selectByVisibleText(visibleText);
	}

	public static void selectByValue(WebElement dropdownElement, String value) {
		dropdown.selectByValue(value);
	}

	public static void selectByIndex(WebElement dropdownElement, int index) {
		dropdown.selectByIndex(index);
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebElement countryDropdown = driver.findElement(By.id("countryDropdownId"));

		// Select by visible text
		SelectDropdown.selectByVisibleText(countryDropdown, "United States");

		// Select by value
		SelectDropdown.selectByValue(countryDropdown, "us");

		// Select by index
		SelectDropdown.selectByIndex(countryDropdown, 2); // Assuming the third country in the list

	}
}
