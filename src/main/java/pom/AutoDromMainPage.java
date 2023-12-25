package pom;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.Keys.DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class AutoDromMainPage {

    @FindBy(how = How.XPATH,
            using = "//input[contains(@placeholder,'Марка')]")
    private SelenideElement carBrandField;

    @FindBy(how = How.XPATH,
            using = "//input[contains(@placeholder,'Модель')]")
    private SelenideElement carModelField;

    @FindBy(how = How.XPATH,
            using = "//button[@type='button'][contains(.,'Топливо')]")
    private SelenideElement fuelField;

    @FindBy(how = How.XPATH,
            using = "//label[@for='sales__filter_unsold'][contains(.,'Непроданные')]")
    private SelenideElement unSalesCheckBox;

    @FindBy(how = How.XPATH,
            using = "//span[@class='css-1hfjy5z eakkndi0'][contains(.,'Расширенный поиск')]")
    private SelenideElement additionalSearch;

    @FindBy(how = How.XPATH,
            using = "//input[contains(@placeholder,'от, км')]")
    private SelenideElement carMileage;

    @FindBy(how = How.XPATH,
            using = "//button[@type='button'][contains(.,'Год от')]")
    private SelenideElement yearOfCar;

    @FindBy(how = How.XPATH,
            using = "//button[@type='submit'][contains(.,'Показать')]")
    private SelenideElement showButton;

    @FindBy(how = How.XPATH,
            using = "/html/body/div[2]/div[2]/div[1]/div/div[3]/a")
    private SelenideElement authButton;

    @FindBy(how = How.XPATH,
            using = "//*[contains(@class, 'css-1rozdag')]")
    private SelenideElement addFavouritesButton;

    @FindBy(how = How.XPATH,
            using = "//*[contains(@data-ftid, 'bull_title')]")
    private SelenideElement nameElement;

    @FindBy(how = How.XPATH,
            using = "/html/body/div[2]/div[5]/div[1]/div[1]/div[10]/div/div[1]/a[1]/div[2]/div[1]/div[1]/span")
    private SelenideElement nameAdElement;

    @FindBy(how = How.XPATH,
            using = "/html/body/div[2]/div[5]/div[1]/div[1]/div[10]/div/div[1]/a[1]/div[3]/div[3]/div/svg/path")
    private SelenideElement favoriteButton;

    @FindBy(how = How.XPATH,
            using = "//*[contains(@class, 'css-1oas0dk e1huvdhj1')]")
    private ElementsCollection listOfAd;

    @FindBy(how = How.XPATH,
            using = "//*[contains(@data-ftid, 'bull_title')]")
    private ElementsCollection carList;

    @FindBy(how = How.XPATH,
            using = "//*[contains(@class, 'css-1jjais5 ena3a8q0')]")
    private SelenideElement secondPageButton;

    public void clickSecondPageButton(){
        secondPageButton.click();
    }

    public void assertCarList() {
        carList.shouldHave(sizeGreaterThan(0));
        carList.forEach(car -> {
            car.shouldNotHave(cssClass("css-12hunv3 e3f4v4l2"));
        });
    }

    public void addFirstElementToTheCollections() {
        SelenideElement firstElement = listOfAd.first();
        firstElement.hover();
    }

    public void clickFavoriteButton() {
        favoriteButton.click();
    }

    public String getTextNameAdElement() {
        return nameElement.getText();
    }

    public void setCarBrandField() throws InterruptedException {
        carBrandField.click();
        String brand = "Toyota";
        carBrandField.setValue(brand);
        Thread.sleep(2000);
        actions().sendKeys(DOWN).sendKeys(ENTER).perform();
        Thread.sleep(2000);
    }

    public void setCarModelField() throws InterruptedException {
        carModelField.click();
        String model = "Harrier";
        carModelField.setValue(model);
        Thread.sleep(2000);
        actions().sendKeys(DOWN).sendKeys(ENTER).perform();
        Thread.sleep(2000);
    }

    public void choosingHybridCar() {
        fuelField.click();
        Actions actions = actions();
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(DOWN).perform();
        }
        fuelField.sendKeys(ENTER);
    }

    public void chooseUnSalesAuto() {
        unSalesCheckBox.click();
    }

    public void chooseAdditionalSearch() {
        additionalSearch.click();
    }

    public void setCarMileage() {
        carMileage.setValue("1");
    }

    public void showButtonClick() {
        showButton.click();
    }

    public void authButtonClick() {
        authButton.click();
    }

    public void clickAddFavourites() {
        addFavouritesButton.click();
    }

    public void chooseFirstElement() {
        SelenideElement firstElement = listOfAd.first();
        firstElement.hover();
    }

    public String getTextNameElement() {
        return nameElement.getText();
    }

    public void addToFavorite() {
        SelenideElement firstAd = $(".css-1k3ms1t");
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(firstAd).perform();

        SelenideElement addToFavoriteButton = firstAd.find(".css-1rozdag");
        addToFavoriteButton.click();
    }
}