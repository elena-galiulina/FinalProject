package ru.praktikum.utils;

import org.apache.commons.lang3.RandomStringUtils;
import ru.praktikum.api.User;

public class RndDataGenerator {

    public static User getRandomUser() {
        String email = RandomStringUtils.randomAlphanumeric(10).toLowerCase() + "@test.com";
        String password = "password123";
        String name = "TestUser";

        return new User(email, password, name);
    }
}