package ru.praktikum.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import ru.praktikum.api.ApiClient;
import ru.praktikum.api.User;
import ru.praktikum.utils.TestContext;
import ru.praktikum.pages.HeaderPage;
import ru.praktikum.pages.LoginPage;
import ru.praktikum.pages.MainPage;
import ru.praktikum.utils.RndDataGenerator;

public class CommonSteps {

    private final TestContext testContext;
    private final ApiClient apiClient = new ApiClient();
    private final MainPage mainPage = new MainPage();

    public CommonSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Дано("незарегистрированный пользователь с уникальными данными")
    public void anUnregisteredUserWithUniqueData() {
        User user = RndDataGenerator.getRandomUser();
        testContext.setUser(user);
    }

    @Дано("пользователь зарегистрирован в системе")
    public void userIsRegisteredInTheSystem() {
        User user = RndDataGenerator.getRandomUser();
        testContext.setUser(user);
        apiClient.registerUser(user).then().statusCode(201);
        Selenide.open("https://qa-desk.stand.praktikum-services.ru/");
    }

    @Дано("пользователь, который уже зарегистрирован в системе")
    public void iAmAUserWhoIsAlreadyRegistered() {
        User user = RndDataGenerator.getRandomUser();
        testContext.setUser(user);
        apiClient.registerUser(user).then().statusCode(201);
    }

    @Тогда("система создает пользователю аккаунт и открывает главную страницу")
    public void theSystemCreatesAnAccountForHimAndOpensTheMainPage() {
        mainPage.checkUserIsLoggedIn();
    }

    @Тогда("пользователь успешно авторизован и видит главную страницу")
    public void heIsSuccessfullyAuthorizedAndSeesTheMainPage() {
        mainPage.checkUserIsLoggedIn();
    }

    @Дано("пользователь, авторизованный в системе")
    public void iAmAnAuthorizedUser() {
        User user = RndDataGenerator.getRandomUser();
        testContext.setUser(user);
        apiClient.registerUser(user).then().statusCode(201);

        Selenide.open("https://qa-desk.stand.praktikum-services.ru/");

        if (mainPage.isLogoutButtonVisible()) {
            mainPage.clickLogoutButton();
        }

        HeaderPage headerPage = new HeaderPage();
        LoginPage loginPage = new LoginPage();

        headerPage.clickLoginButton();
        loginPage.login(user);
    }
}