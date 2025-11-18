package ru.praktikum.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.praktikum.utils.TestContext;
import ru.praktikum.pages.AdvertisementPage;
import ru.praktikum.pages.HeaderPage;
import ru.praktikum.pages.MainPage;
import ru.praktikum.pages.UserProfilePage;

public class CreateAdSteps {

    private final TestContext testContext;
    private final HeaderPage headerPage = new HeaderPage();
    private final AdvertisementPage createAdPage = new AdvertisementPage();
    private final UserProfilePage myProfilePage = new UserProfilePage();
    private final MainPage mainPage = new MainPage();

    private String adTitle;

    public CreateAdSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Когда("пользователь создает новое объявление с валидными данными")
    public void iCreateANewAdWithValidData() {
        adTitle = "Тест " + System.currentTimeMillis();
        String price = "12345";

        headerPage.clickCreateAdButton();
        createAdPage.createAd(adTitle, price);
        mainPage.waitForPageLoad();
    }

    @Тогда("созданное объявление появляется в списке объявлений пользователя")
    public void thisAdAppearsInMyAdList() {
        headerPage.clickProfileIcon();
        myProfilePage.waitForPageLoad();
        myProfilePage.verifyAdIsVisible(adTitle);
    }
}