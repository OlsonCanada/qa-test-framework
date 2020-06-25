package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    public WebDriver driver;
    public Properties prop = new Properties();
    public static String application;
    public String path = System.getProperty("user.dir");

    public WebDriver initalizeDriver() throws IOException {

        FileInputStream fin = new FileInputStream(path+"\\src\\main\\resources\\config.properties");
        prop.load(fin);
        String browserName = prop.getProperty("browser");
        application = prop.getProperty("URL");

        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals(("firefox"))){
            System.out.println("Firefox not supported yet");
        }
        return driver;
    }

    //TODO : Write common funtion for wait. Review the funtion available on BP automation
}
