package api_utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import genricUtilities.JavaUtility;

/**
 * Listener class for generating Extent Reports for API Automation.
 * Implements TestNG ITestListener.
 * No Selenium or WebDriver dependency.
 * @author Sharath
 */
public class ExtentReportManager implements ITestListener {

    ExtentReports report;
    ExtentTest test;

    public void onStart(ITestContext context) {
        System.out.println("Suite execution Started");

        // Generate dynamic report file name using date
        ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+new JavaUtility().getSystemDate()+".html");
		
      
        esr.config().setDocumentTitle("API Execution Report");
        esr.config().setTheme(Theme.DARK);
        esr.config().setReportName("API Automation Framework Execution");

        // Setup Extent Report
        report = new ExtentReports();
        report.attachReporter(esr);
        report.setSystemInfo("Platform", "Windows");
        report.setSystemInfo("Environment", "Test Env");
        report.setSystemInfo("Java Version", System.getProperty("java.version"));
        report.setSystemInfo("Reporter Name", "Sharath");
    }

    public void onFinish(ITestContext context) {
        System.out.println("Suite execution Finished");
        report.flush(); // Write everything to report
    }

    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName + " - Test execution Started");
        test = report.createTest(methodName); // Create test node in report
    }

    public void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName + " - Test PASSED");
        test.log(Status.PASS, methodName + " - Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName + " - Test FAILED");
        test.log(Status.FAIL, methodName + " - Test Failed");
        test.log(Status.FAIL, result.getThrowable()); // Log error/exception
    }

    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.println(methodName + " - Test SKIPPED");
        test.log(Status.SKIP, methodName + " - Test Skipped");
        test.log(Status.SKIP, result.getThrowable()); // Log reason for skip
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not used
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result); // Treat timeout as failure
    }
}
