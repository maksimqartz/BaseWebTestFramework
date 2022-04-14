package pages.tr_home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static constants.Constant.Cites.MSK_CITY;
import static constants.Constant.Cites.SPB_CITY;

/**
 * Inherited from base page
 */
public class TrendRealtyHomePage extends BasePage {

    /**
     * Constructor with a super driver
     */
    public TrendRealtyHomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By numberOfRoomsSelector = By.xpath("//div//input[@name='room']/parent::div");
    private final By select2ERooms = By.xpath("//ul[@class='dropdown__list px-4']/li[4]");
    private final By findApplyButton = By.xpath("//div[@class='filter__apply']");


    private final By citesPopup = By.xpath("//div[@class='popup__content popup__content_initial-bottom modal city-select__modal popup__content popup__content_from-bottom']");
    private final By findYesCityButton = By.xpath("//div[@class='popup__content popup__content_initial-bottom modal city-select__modal popup__content popup__content_from-bottom']//*/button[@class='btn btn_main']");
    private final By findNoCityButton = By.xpath("//div[@class='popup__content popup__content_initial-bottom modal city-select__modal popup__content popup__content_from-bottom']//*/a[@href='https://msk.trendrealty.ru']");

    public TrendRealtyHomePage chooseNumberOfRooms() {
        driver.findElement(numberOfRoomsSelector).click();
        driver.findElement(select2ERooms).click();
        driver.findElement(select2ERooms).sendKeys(Keys.ESCAPE);


        return this;
    }

    public TrendRealtyHomePage choosePopupCity(String cityForPopup) {
        WebElement popupCityElement = driver.findElement(citesPopup);
        awaitVisibleElement(popupCityElement);
        switch (cityForPopup) {
            case SPB_CITY:
                WebElement yesButtonCity = driver.findElement(findYesCityButton);
                awaitVisibleElement(yesButtonCity).click();
                break;
            case MSK_CITY:
                WebElement noButtonCity = driver.findElement(findNoCityButton);
                awaitVisibleElement(noButtonCity).click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + cityForPopup);
        }

        return this;
    }

    public void clickOnApplyButton() {
        WebElement buttonFindElement = driver.findElement(findApplyButton);
        awaitVisibleElement(buttonFindElement).click();

    }
}
