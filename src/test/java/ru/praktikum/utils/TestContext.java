package ru.praktikum.utils;

import ru.praktikum.api.User;

public class TestContext {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}