package ru.praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class UserProfilePage {

    private final SelenideElement profileTitle = $x("//h1[@class='h1 zeroMargin' and text()='Мой профиль']");
    private final ElementsCollection adCards = $$(".card");

    public void waitForPageLoad() {
        profileTitle.shouldBe(visible, Duration.ofSeconds(5));
    }

    public void verifyAdIsVisible(String adTitle) {
        SelenideElement adElement = $x("//div[@class='card']//h2[@class='h2' and text()='" + adTitle + "']");
        adElement.scrollTo().shouldBe(visible, Duration.ofSeconds(1));
    }

    public void clickEditButtonForAd(String adTitle) {
        $x("//h2[contains(text(),'" + adTitle + "')]/ancestor::div[@class='card']//button[contains(text(), 'Редактировать')]").click();
    }

    public void clickDeleteButtonForAd(String adTitle) {
        $x("//h2[contains(text(),'" + adTitle + "')]/ancestor::div[@class='card']//button[contains(text(), 'Удалить')]").click();
    }

    public void verifyAdIsDisappeared(String adTitle) {
        $x("//h2[contains(text(),'" + adTitle + "')]").should(disappear, Duration.ofSeconds(5));
    }

    public AdCard getFirstAdCard() {
        return new AdCard(adCards.first());
    }
}