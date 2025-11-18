package ru.praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import ru.praktikum.api.User;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private static final String URL = "https://qa-desk.stand.praktikum-services.ru/";
    private final SelenideElement loginOrRegisterButton = $("button.buttonSecondary[style*='max-width: 217px']");
    private final SelenideElement noAccountButton = $("button.buttonSecondary[style*='max-width: 166px']");
    private final SelenideElement emailInput = $("input[name='email']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement submitPasswordInput = $("input[name='submitPassword']");
    private final SelenideElement createAccountButton = $("button[type='submit'].buttonPrimary");
    private final SelenideElement errorMessage = $("span.input_span__yWPqB");
    private final SelenideElement logoutButton = $("button.btnSmall[type='button']");

    public void openPage() {
        open(URL);
    }

    public void clickLoginOrRegisterButton() {
        loginOrRegisterButton.click();
    }

    public void clickNoAccountButton() {
        noAccountButton.click();
    }

    public void setEmail(String email) {
        emailInput.setValue(email);
    }

    public void setPassword(String password) {
        passwordInput.setValue(password);
    }

    public void setSubmitPassword(String password) {
        submitPasswordInput.setValue(password);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public void register(User user) {
        if (logoutButton.exists()) {
            logoutButton.click();
        }
        clickLoginOrRegisterButton();
        clickNoAccountButton();
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setSubmitPassword(user.getPassword());
        clickCreateAccountButton();
    }

    public void registerExistingUser(User user) {
        if (logoutButton.exists()) {
            logoutButton.click();
        }
        loginOrRegisterButton.shouldBe(visible).click();
        clickNoAccountButton();
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setSubmitPassword(user.getPassword());
        clickCreateAccountButton();
    }

    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }
}