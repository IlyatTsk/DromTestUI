import constants.Endpoints;
import org.junit.jupiter.api.Test;
import pom.AutoDromMainPage;

import static com.codeborne.selenide.Selenide.open;

public class FilterTest extends BaseTest {

    @Test
    public void filterTestByParams() throws InterruptedException {
        AutoDromMainPage autoDromMainPage = open(Endpoints.BASE_URL, AutoDromMainPage.class);
        autoDromMainPage.setCarBrandField();
        autoDromMainPage.setCarModelField();
        autoDromMainPage.choosingHybridCar();
        autoDromMainPage.chooseUnSalesAuto();
        autoDromMainPage.chooseAdditionalSearch();
        autoDromMainPage.setCarMileage();
        autoDromMainPage.showButtonClick();

        autoDromMainPage.assertCarList();

        autoDromMainPage.clickSecondPageButton();
        autoDromMainPage.assertCarList();
    }
}
