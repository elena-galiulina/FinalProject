package ru.praktikum.steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import ru.praktikum.utils.TestContext;
import ru.praktikum.pages.EditAdPage;
import ru.praktikum.pages.HeaderPage;
import ru.praktikum.pages.UserProfilePage;

public class EditDeleteSteps {

    private final TestContext testContext;
    private final HeaderPage headerPage = new HeaderPage();
    private final UserProfilePage userProfilePage = new UserProfilePage();
    private final EditAdPage editAdPage = new EditAdPage();
    private String adTitle;

    public EditDeleteSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("пользователь редактирует свое объявление")
    public void userEditsTheirAd() {
        headerPage.clickProfileIcon();
        userProfilePage.waitForPageLoad();
        adTitle = "Тест " + System.currentTimeMillis();
        userProfilePage.clickEditButtonForAd(adTitle);
    }

    @When("пользователь удаляет свое объявление")
    public void userDeletesTheirAd() {
        headerPage.clickProfileIcon();
        userProfilePage.waitForPageLoad();
        adTitle = "Тест " + System.currentTimeMillis();
        userProfilePage.clickDeleteButtonForAd(adTitle);
    }

    @Then("форма редактирования объявления открывается")
    public void editAdFormOpens() {
        editAdPage.waitForPageLoad();
    }

    @Then("объявление успешно удаляется из списка")
    public void adIsSuccessfullyDeleted() {
        userProfilePage.verifyAdIsDisappeared(adTitle);
    }
}