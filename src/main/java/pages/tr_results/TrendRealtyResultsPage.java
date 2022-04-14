package pages.tr_results;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

import java.time.Duration;

import static constants.Constant.Elements.RESULT_CARDS;

public class TrendRealtyResultsPage extends BasePage {

    public TrendRealtyResultsPage(WebDriver driver) {
        super(driver);
    }

    private final By flatCard = By.xpath("//div[@class='page_results__col col-12 col-sm-6 col-lg-4']");

    public void countResultCards() {
        Assert.assertEquals(awaitCountElements(flatCard, RESULT_CARDS), RESULT_CARDS);
    }
}
