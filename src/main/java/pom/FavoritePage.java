package pom;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FavoritePage {

    @FindBy(how = How.XPATH,
            using = "/*[@id=\"bulletinId\"]/div[2]/div[1]/a")
    private SelenideElement favoriteAd;

    public String getTextFavoriteAd() {
        return favoriteAd.getText();
    }
}
