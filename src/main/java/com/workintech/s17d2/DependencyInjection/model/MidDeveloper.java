package com.workintech.s17d2.DependencyInjection.model;

import com.workintech.s17d2.DependencyInjection.controller.Experience;

public class MidDeveloper extends Developer {
    public MidDeveloper(int id, String name, double salary) {
        super(id, name, salary, Experience.MID);
    }
}
