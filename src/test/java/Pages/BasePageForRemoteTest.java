package Pages;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BasePageForRemoteTest {

    public WebDriver driver;
    public Properties prop = new Properties();
    public static String application;
    public String path = System.getProperty("user.dir");
    DesiredCapabilities dc = new DesiredCapabilities();
    String node = "https://localhost:4444/wd/hub";

    public WebDriver initalizeDriver() throws IOException {

        FileInputStream fin = new FileInputStream(path+"\\src\\main\\resources\\config.properties");
        prop.load(fin);
        String browserName = prop.getProperty("browser");
        application = prop.getProperty("URL");

        if (browserName.equals("chrome")){
            dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
            dc.setCapability(CapabilityType.PLATFORM_NAME,"WINDOWS");
        } else if (browserName.equals(("firefox"))){
            dc.setBrowserName("firefox");
            dc.setPlatform(Platform.WIN10);
        }
        WebDriver driver = new RemoteWebDriver(new URL(node),dc);
        return driver;
    }
}
