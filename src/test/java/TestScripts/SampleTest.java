package TestScripts;

import Pages.BasePage;
import Pages.OITPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SampleTest extends BasePage {

    @BeforeTest
    public void dummyBeforeTest() throws IOException, InterruptedException {
        driver = initalizeDriver();
        driver.get(application);
        Thread.sleep(10000);
        System.out.println("This is before class");
    }

    @Test
    public void dummyTest() throws IOException {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"XYZ");
        System.out.println("Test Executed");
    }

    @Test
    public void oitTest() throws InterruptedException {
        OITPage op = new OITPage(driver);
        op.fillOITApp();
    }

    @AfterTest
    public void dummyAfterTest(){
        //driver.quit();
        System.out.println("This is after class");
    }
}
