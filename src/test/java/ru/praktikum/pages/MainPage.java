package ru.praktikum.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement logoutButton = $("button.btnSmall[type='button']");

    public void checkUserIsLoggedIn() {
        logoutButton.shouldBe(visible);
    }

    public boolean isLogoutButtonVisible() {
        return logoutButton.exists();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void waitForPageLoad() {
        $x("//div[@class='input_inputDefaultSearch__EKhe3']//input[@placeholder='Я хочу купить...']")
                .shouldBe(visible, Duration.ofSeconds(5));
    }
}