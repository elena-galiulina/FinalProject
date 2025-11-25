package ru.praktikum.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class EditAdPage {

    private final SelenideElement pageTitle = $x("//h1[contains(text(), 'Редактирование объявления')]");

    public void waitForPageLoad() {
        pageTitle.shouldBe(visible, Duration.ofSeconds(5));
    }
}