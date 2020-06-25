package TestResources;

import Pages.BasePage;
import TestScripts.SampleTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class NGListeners extends BasePage implements ITestListener {
    static ExtentReports extent = ExtentReporter.getReport();
    static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getTestClass().getName()+"::"+result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String logText = "Test Method "+result.getMethod().getMethodName()+" is Successful";
        extentTest.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        extentTest.get().fail("Exception Occured"+exceptionMessage.replaceAll(",","<br>")+"\n");

        //TODO : generalise test class name
        WebDriver driver = ((SampleTest)result.getInstance()).driver;
        String path = takeScreenshot(driver, result.getMethod().getMethodName());
        try{
            extentTest.get().fail("Screenshot at Failure", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        }catch (IOException e){
            extentTest.get().fail("Test Failed, cannot attach screenshot");
        }

        String logText = "Test Method "+methodName+" Failed";
        extentTest.get().log(Status.FAIL, "Test Failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        if(extent !=null){
            extent.flush();
        }
    }

    public String takeScreenshot(WebDriver driver, String methodName) {
        this.driver = driver;
        String fileName = getScreenShotName(methodName);
        String directory = System.getProperty("user.dir")+"\\screenshots\\";
        String path = directory+fileName;

        try{
            File screenshot = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(path));
            System.out.println("Screenshot Stored at : "+path);
        }catch (Exception e){
            e.printStackTrace();
        }
        return path;
    }

    private String getScreenShotName(String methodName) {
        Date d = new Date();
        String fileName = methodName+"_"+d.toString().replace(":","_").replace(" ","_")+".png";
        return fileName;
    }

}
