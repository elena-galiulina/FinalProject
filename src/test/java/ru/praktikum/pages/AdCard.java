package ru.praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdCard {

    private final SelenideElement cardElement;
    private final SelenideElement editButton;
    private final SelenideElement deleteButton;

    public AdCard(SelenideElement cardElement) {
        this.cardElement = cardElement;
        this.editButton = cardElement.$(By.cssSelector("button:contains('Редактировать')"));
        this.deleteButton = cardElement.$(By.cssSelector("button:contains('Удалить')"));
    }

    public void clickEditButton() {
        editButton.shouldBe(exist).shouldBe(visible).click();
    }

    public void clickDeleteButton() {
        deleteButton.shouldBe(visible).click();
    }

    public AdCard shouldHaveEditButton() {
        editButton.shouldBe(visible);
        return this;
    }

    public AdCard shouldHaveDeleteButton() {
        deleteButton.shouldBe(visible);
        return this;
    }
}