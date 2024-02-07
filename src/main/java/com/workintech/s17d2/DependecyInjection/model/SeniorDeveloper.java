package com.workintech.s17d2.DependecyInjection.model;

import com.workintech.s17d2.DependecyInjection.rest.Experience;

public class SeniorDeveloper extends Developer {
    public SeniorDeveloper(int id, String name, double salary, Experience experience) {
        super(id, name, salary, experience);
    }
}
