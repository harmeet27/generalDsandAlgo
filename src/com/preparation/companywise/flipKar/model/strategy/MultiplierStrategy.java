package com.preparation.companywise.flipKar.model.strategy;

public class MultiplierStrategy implements PricingStrategy {
    @Override
    public double computePrice(double multiplierFactor, int basePrice) {
        return basePrice * multiplierFactor;
    }
}
