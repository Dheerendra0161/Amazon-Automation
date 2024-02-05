package amzon.Utils;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReporter {

	public static  ExtentReports generateExtentReports() {

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				new File(System.getProperty("user.dir") + "\\Screenshot\\ExtentReports\\extentReports.html"));

		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Amazon Test Aautomation Reports");
		sparkReporter.config().setReportName("Amazon Test Aautomation");
		sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");

		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Application URL", "https://www.amazon.com/");
		extentReport.setSystemInfo("BrowserName", "Chrome");
		extentReport.setSystemInfo("OperatingSystem", "Microsoft Windows 11");
		extentReport.setSystemInfo("Java Version", "21.0.1");

		return extentReport;

	}

}
