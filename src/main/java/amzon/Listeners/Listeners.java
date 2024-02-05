package amzon.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import amzon.Utils.ExtentReporter;
import amzon.Utils.TakeScreenShot;

public class Listeners implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extentTestObj;

	@Override
	public void onStart(ITestContext context) {

		/*
		 * onStart is a method in the ITestListener interface that is called when the
		 * entire TestNG suite starts execution. It is invoked once at the beginning of
		 * the test suite execution, before any test classes or test methods are
		 * executed.
		 */
		extentReport = ExtentReporter.generateExtentReports();

	}

	@Override
	public void onTestStart(ITestResult result) {
		/*
		 * onTestStart is a method in the ITestListener interface that is called when an
		 * individual test method starts execution.
		 */
		extentTestObj = extentReport.createTest(result.getName());
		extentTestObj.log(Status.INFO, result.getName() + " Started executing");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTestObj.log(Status.PASS, result.getName() + " Got succesfully executed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		String destinationPath = TakeScreenShot.getScreenShot(driver, result.getName());

		extentTestObj.addScreenCaptureFromPath(destinationPath);
		extentTestObj.log(Status.INFO, result.getThrowable());
		extentTestObj.log(Status.FAIL, result.getName() + " Got failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTestObj.log(Status.INFO, result.getThrowable());
		extentTestObj.log(Status.SKIP, result.getName() + " Got Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();

		// To open automatically screenshot
		String pathToExtentReport = System.getProperty("user.dir") + "\\Screenshot\\ExtentReports\\extentReports.html";
		File extentReport = new File(pathToExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	// @Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

}
