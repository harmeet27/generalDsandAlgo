package com.preparation.companywise.flipKar.model;

import com.preparation.companywise.flipKar.model.strategy.PricingStrategy;

public class SedanVehicle extends Vehicle {
    private PricingStrategy pricingStrategy;

    public SedanVehicle(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;

        this.vehicleType = CarType.SEDAN.getVehicleType();
    }

    @Override
    public double getPrice() {
        return basePrice + pricingStrategy.computePrice(0.3, basePrice);
    }
}
