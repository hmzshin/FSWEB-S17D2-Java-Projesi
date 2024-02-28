package com.workintech.s17d2.DependencyInjection.model;

import com.workintech.s17d2.DependencyInjection.controller.Experience;

public class JuniorDeveloper extends Developer {
    public JuniorDeveloper(int id, String name, double salary) {
        super(id, name, salary, Experience.JUNIOR);
    }
}
