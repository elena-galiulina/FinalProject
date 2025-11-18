package ru.praktikum.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.praktikum.utils.TestContext;
import ru.praktikum.pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationSteps {

    private final TestContext testContext;
    private final RegistrationPage registrationPage = new RegistrationPage();

    public RegistrationSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Когда("пользователь выполняет регистрацию")
    public void hePerformsRegistration() {
        registrationPage.openPage();
        registrationPage.register(testContext.getUser());
    }

    @Когда("пользователь пытается зарегистрироваться повторно, используя те же данные")
    public void iTryToRegisterAgainWithTheSameData() {
        registrationPage.openPage();
        registrationPage.registerExistingUser(testContext.getUser());
    }

    @Тогда("пользователь видит сообщение об ошибке {string}")
    public void iSeeAnErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = registrationPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}