package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.tr_home.TrendRealtyHomePage;
import pages.tr_results.TrendRealtyResultsPage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    // Tests need driver that will be thrown, so it needs to be protected
    protected WebDriver driver = CommonActions.createDriver();
    // For tests need to create instances of classes for pages
    protected BasePage basePage = new BasePage(driver);
    protected TrendRealtyHomePage trendRealtyHomePage = new TrendRealtyHomePage(driver);
    protected TrendRealtyResultsPage trendRealtyResultsPage = new TrendRealtyResultsPage(driver);

    // Cookie and local storage cleaner method
    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }

}
