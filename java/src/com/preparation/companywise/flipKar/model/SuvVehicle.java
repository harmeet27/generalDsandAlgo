package com.preparation.companywise.flipKar.model;

import com.preparation.companywise.flipKar.model.strategy.PricingStrategy;

public class SuvVehicle extends Vehicle {
    private PricingStrategy pricingStrategy;

    public SuvVehicle(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;

        this.vehicleType = CarType.SUV.getVehicleType();
    }

    @Override
    public double getPrice() {
        return basePrice + pricingStrategy.computePrice(0.5, basePrice);
    }
}
