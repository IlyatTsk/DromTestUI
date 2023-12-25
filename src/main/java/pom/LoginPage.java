package pom;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import constants.Endpoints;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.ID,
            using = "sign")
    private SelenideElement loginInput;

    @FindBy(how = How.ID,
            using = "password")
    private SelenideElement passwordInput;

    @FindBy(how = How.ID,
            using = "signbutton")
    private SelenideElement signButton;

    public void setLoginInput() {
        loginInput.setValue(Endpoints.login);
    }

    public void setPasswordInput() {
        passwordInput.setValue(Endpoints.password);
    }

    public void signButtonClick() {
        signButton.click();
    }

    public void authorization() {
        loginInput.setValue(Endpoints.login);
        passwordInput.setValue(Endpoints.password);
        signButton.click();
    }
}