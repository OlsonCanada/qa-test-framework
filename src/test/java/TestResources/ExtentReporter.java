package TestResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Date;

public class ExtentReporter {
    static ExtentReports extent;

    public static ExtentReports getReport(){
        String fileName = getReportName();
        String directory = System.getProperty("user.dir")+"\\reports\\";
        String path = directory+fileName;

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Test Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.setSystemInfo("Tester","John Jethi");
        extent.setSystemInfo("AUT","Dummy Application");
        extent.attachReporter(reporter);

        return extent;
    }

    private static String getReportName() {
        Date d = new Date();
        String fileName = "Report"+"_"+d.toString().replace(":","_").replace(" ","_")+".html";
        return fileName;
    }

}
