package com.workintech.s17d2.DependencyInjection.model;

import com.workintech.s17d2.DependencyInjection.controller.Experience;
import com.workintech.s17d2.DependencyInjection.tax.Taxable;

public class DeveloperFactory {

    public static Developer createDeveloper(Developer developer, Taxable taxRate) {

        Developer dev = null;

        if (developer.getExperience().equals(Experience.JUNIOR)) {
            double tax = developer.getSalary() * taxRate.getSimpleTaxRate();
            double gross = developer.getSalary();
            double net = gross - tax;
            dev = new JuniorDeveloper(developer.getId(), developer.getName(), net);
        } else if (developer.getExperience().equals(Experience.MID)) {
            double tax = developer.getSalary() * taxRate.getMiddleTaxRate();
            double gross = developer.getSalary();
            double net = gross - tax;
            dev = new JuniorDeveloper(developer.getId(), developer.getName(), net);
        } else {
            double tax = developer.getSalary() * taxRate.getUpperTaxRate();
            double gross = developer.getSalary();
            double net = gross - tax;
            dev = new JuniorDeveloper(developer.getId(), developer.getName(), net);
        }

        return dev;

    }
}
