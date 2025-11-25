package ru.praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import ru.praktikum.api.User;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement emailInput = $("input[name='email']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement submitLoginButton = $("button[type='submit'].buttonPrimary[style*='max-width: 111px']");

    public void login(User user) {
        emailInput.shouldBe(visible).setValue(user.getEmail());
        passwordInput.shouldBe(visible).setValue(user.getPassword());
        submitLoginButton.shouldBe(visible).click();
    }
}