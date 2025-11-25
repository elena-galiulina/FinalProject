package ru.praktikum.utils;

import net.datafaker.Faker;
import ru.praktikum.api.User;
import java.util.Locale;
import java.util.Random;

public class RndDataGenerator {
    private static final Faker faker = new Faker(new Locale("ru"));
    private static final Random random = new Random();
    public static User getRandomUser() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8, 12, true, true, true); // 8-12 символов, с цифрами, спецсимволами
        String name = faker.name().fullName();

        return new User(email, password, name);
    }

    public static String generateRandomAdTitle() {
        return faker.commerce().productName() + " " + System.currentTimeMillis();
    }

    public static String generateRandomPrice() {
        return String.valueOf(faker.number().numberBetween(100, 100000));
    }

}