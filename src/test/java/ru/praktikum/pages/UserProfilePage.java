package ru.praktikum.pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UserProfilePage {

    public void waitForPageLoad() {
        $x("//h1[@class='h1 zeroMargin' and text()='Мой профиль']").shouldBe(visible, Duration.ofSeconds(5));
    }

    public void verifyAdIsVisible(String adTitle) {
        SelenideElement adElement = $x("//div[@class='card']//h2[@class='h2' and text()='" + adTitle + "']");
        adElement.scrollTo().shouldBe(visible, Duration.ofSeconds(1));
    }

    public void clickEditButtonForAd(String adTitle) {
        $x("//h3[contains(text(),'" + adTitle + "')]/following::button[contains(text(), 'Редактировать')]").click();
    }

    public void clickDeleteButtonForAd(String adTitle) {
        $x("//h3[contains(text(),'" + adTitle + "')]/following::button[contains(text(), 'Удалить')]").click();
    }

    public void verifyAdIsDisappeared(String adTitle) {
        $(byText(adTitle)).should(disappear);
    }
}