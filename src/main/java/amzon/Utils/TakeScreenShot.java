package amzon.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class TakeScreenShot {
	WebDriver driver;

	public static String getScreenShot(WebDriver driver, String testName) {

		File screenShotFilePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "\\Screenshot\\" + testName + ".png";
		File file = new File(destinationPath);
		try {

			FileUtils.copyFile(screenShotFilePath, file);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationPath;

	}
}
/*
 * The FileUtils.copyFile method takes two parameters: the source File object
 * (representing the screenshot obtained from getScreenshotAs) and the
 * destination File object (representing the destination where the screenshot
 * will be saved). It copies the contents of the source file to the destination
 * file.
 */
