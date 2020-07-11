package com.preparation.companywise.flipKar.model.strategy;

public interface PricingStrategy {

    double computePrice(double pricingFactor, int basePrice);
}
