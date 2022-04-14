package tests.searchapartment;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Cites.SPB_CITY;
import static constants.Constant.Urls.TRENDREALTY_HOME_PAGE;

public class SearchApartmentTest extends BaseTest {

    @Test
    public void checkIsRedirectToResults() {
        basePage.openPage(TRENDREALTY_HOME_PAGE);

        trendRealtyHomePage
                .choosePopupCity(SPB_CITY)
                .chooseNumberOfRooms()
                .clickOnApplyButton();

        trendRealtyResultsPage.countResultCards();
    }
}
