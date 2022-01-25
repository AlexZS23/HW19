package HomeWork19;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static WebDriver webDriver;

    @BeforeClass
    public void initWebDriver() {
        String browser = "chrome";
        switch (browser){
            case "chrome":
                webDriver = DriverInit.getWebDriver(DriverInit.Browser.CHROME);
                break;
            case "ff":
                webDriver = DriverInit.getWebDriver(DriverInit.Browser.FF);
                break;
            default:
                System.out.println("You need to initialize browser");
        }
    }

    @AfterClass
    public void closeBrowser(){
        webDriver.quit();
    }
}
