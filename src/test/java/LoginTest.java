import constants.Endpoints;
import org.junit.jupiter.api.Test;
import pom.AutoDromMainPage;
import pom.FavoritePage;
import pom.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BaseTest {

    @Test
    public void loginAndAddFavouritesTest() throws InterruptedException {
        AutoDromMainPage autoDromMainPage = open(Endpoints.BASE_URL, AutoDromMainPage.class);
        Thread.sleep(2000);
        autoDromMainPage.authButtonClick();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.authorization();

        autoDromMainPage.addFirstElementToTheCollections();

        String nameAd = autoDromMainPage.getTextNameAdElement();
        autoDromMainPage.clickFavoriteButton();

        open("https://my.drom.ru/personal/bookmark");

        FavoritePage favoritePage = page(FavoritePage.class);
        String nameMyAd = favoritePage.getTextFavoriteAd();

        assert nameAd.equals(nameMyAd) : "Названия объявлений не совпадают";
    }
}
