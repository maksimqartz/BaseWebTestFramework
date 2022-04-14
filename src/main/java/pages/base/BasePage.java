package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constant.TimeoutData.EXPLICIT_TIMEOUT;

/**
 * A class that describes the general logic that is reproduced on other pages.
 * All other page classes will inherit from this class.
 */
public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver; // Passing the driver to the current variable
    } // Constructor that accepts a driver

    public void openPage(String url) {
        driver.get(url);
    } // Method for opening pages, similar mechanics with selenide

    public WebElement awaitVisibleElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    } // Explicitly waiting for the page to load

    public int awaitCountElements(By element, int size) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT)).until(ExpectedConditions.numberOfElementsToBe(element, size));
        return size;
    }
}
