package ru.praktikum.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private final SelenideElement loginOrRegisterButton = $("button.buttonSecondary[style*='max-width: 217px']");
    private final SelenideElement createAdButton = $("button.buttonPrimary[style*='max-width: 250px']");
    private final SelenideElement profileIcon = $("svg.svgSmall");

    public void clickLoginButton() {
        loginOrRegisterButton.click();
    }

    public void clickCreateAdButton() {
        createAdButton.click();
    }

    public void clickProfileIcon() {
        profileIcon.click();
    }
}