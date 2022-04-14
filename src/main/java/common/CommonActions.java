package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static common.Config.PLATFORM_BROWSER;
import static constants.Constant.TimeoutData.IMPLICIT_TIMEOUT;

/**
 * The class in which the method for selecting the environment and starting the driver is located
 */
public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;

        // Driver selection by switch, the value is pulled from the config file
        switch (PLATFORM_BROWSER) {
            case "windows_chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); // Set the directory for the driver
                driver = new ChromeDriver(); // Initialize the variable with the WebDriver
                break;
            default:
                Assert.fail("Incorrect platform or browser name: " + PLATFORM_BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));
        return driver;
    }
}
