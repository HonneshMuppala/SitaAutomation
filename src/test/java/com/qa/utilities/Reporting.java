package com.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Reporting extends TestListenerAdapter {
    public ExtentHtmlReporter htmlReport;
    public ExtentReports SitaReport;
    public ExtentTest SitaTest;

    public void onStart(ITestContext testContext) {
        String dateStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "Test-Automation-report-" + dateStamp + ".html";
        htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Report/" + reportName);
        htmlReport.config().setDocumentTitle("Sita Website Execution Summary Report");
        htmlReport.config().setTheme(Theme.STANDARD);
        htmlReport.config().setAutoCreateRelativePathMedia(true);

        SitaReport = new ExtentReports();
        SitaReport.attachReporter(htmlReport);
        SitaReport.setSystemInfo("QA Name", "Honnesh Muppala");
        SitaReport.setSystemInfo("Testing on", "Functional Testing of Sita Web App");
        SitaReport.setSystemInfo("OS", "Windows 11");
        SitaReport.setSystemInfo("Hostname", "Honnesh Muppala");
    }

    public void onFinish(ITestContext testContext) {
        SitaReport.flush();
    }

    public void onTestSuccess(ITestResult tr) {
        SitaTest = SitaReport.createTest(tr.getName());
        SitaTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult tr) {
        SitaTest = SitaReport.createTest(tr.getName());
        SitaTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
        SitaTest.log(Status.FAIL, tr.getThrowable());

        String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() + ".png";
        File path = new File(screenshotPath);
        if (path.exists()) {
            try {
                SitaTest.fail("Test failed. Screenshot:",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onTestSkipped(ITestResult tr) {
        SitaTest = SitaReport.createTest(tr.getName());
        SitaTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.BLUE));

        String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() + ".png";
        File path = new File(screenshotPath);
        if (path.exists()) {
            try {
                SitaTest.skip("Test skipped. Screenshot:",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
