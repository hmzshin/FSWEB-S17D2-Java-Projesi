package com.workintech.s17d2.DependencyInjection.tax;

import org.springframework.stereotype.Component;

@Component
public class DeveloperTax implements Taxable {

    @Override
    public double getSimpleTaxRate() {
        return 0.25;
    }

    @Override
    public double getMiddleTaxRate() {
        return 0.20;
    }

    @Override
    public double getUpperTaxRate() {
        return 0.30;
    }
}
