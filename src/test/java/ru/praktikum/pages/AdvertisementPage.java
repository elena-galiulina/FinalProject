package ru.praktikum.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdvertisementPage {
    private final SelenideElement nameInput = $("input[name='name']");
    private final SelenideElement priceInput = $("input[name='price']");
    private final SelenideElement publishButton = $("button[type='submit'].buttonPrimary[style*='max-width: 174px']");

    public void createAd(String name, String price) {
        nameInput.shouldBe(visible).setValue(name);
        priceInput.shouldBe(visible).setValue(price);
        publishButton.shouldBe(visible).click();
    }
}