package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OITPage extends BasePage{
    public WebDriver driver;

    By userID = By.id("Login_Username");

    public OITPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement userID(){return driver.findElement(userID);}

    By passWd = By.id("Login_Password");
    public WebElement passWd(){return driver.findElement(passWd);}

    By login = By.cssSelector("#main-content > div > div.row.login-block > div.col-md-7.col-sm-7 > form > fieldset > input");
    public WebElement login(){return driver.findElement(login);}

    By eleForm = By.xpath("//*[@id=\"main-content\"]/div[1]/div/div[2]/div[2]/a/img");
    public WebElement eleForm(){return driver.findElement(eleForm);}

    By signBtw = By.xpath("//*[@id=\"MainContent_gvApplicant_btnSign_0\"]");
    public WebElement signBtw(){return driver.findElement(signBtw);}

    By okBtw = By.xpath("//*[@id=timeLeftWindow]/div/button[2]");
    public WebElement okBtw(){return driver.findElement(okBtw);}

    public void fillOITApp() throws InterruptedException {

        OITPage op1 = new OITPage(driver);
        Thread.sleep(5000);
        op1.userID().click();
        op1.userID().sendKeys("TesTes66380");

        op1.passWd().click();
        op1.passWd().sendKeys("Dev@acc123");

        op1.login().click();
        Thread.sleep(5000);
        op1.eleForm().click();
        Thread.sleep(5000);
        op1.okBtw().click();
        Thread.sleep(5000);
    }
}
