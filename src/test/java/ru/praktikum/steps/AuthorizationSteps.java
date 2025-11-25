package ru.praktikum.steps;

import io.cucumber.java.en.When;
import ru.praktikum.utils.TestContext;
import ru.praktikum.pages.HeaderPage;
import ru.praktikum.pages.LoginPage;
import ru.praktikum.pages.MainPage;

public class AuthorizationSteps {

    private final TestContext testContext;
    private final HeaderPage headerPage = new HeaderPage();
    private final LoginPage loginPage = new LoginPage();
    private final MainPage mainPage = new MainPage();

    public AuthorizationSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("пользователь авторизуется со своими учетными данными")
    public void heLogsInWithHisCredentials() {
        if (mainPage.isLogoutButtonVisible()) {
            mainPage.clickLogoutButton();
        }
        headerPage.clickLoginButton();
        loginPage.login(testContext.getUser());
    }
}