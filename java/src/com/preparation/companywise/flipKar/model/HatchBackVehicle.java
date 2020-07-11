package com.preparation.companywise.flipKar.model;

import com.preparation.companywise.flipKar.model.strategy.PricingStrategy;

public class HatchBackVehicle extends Vehicle {

    private PricingStrategy pricingStrategy;


    public HatchBackVehicle(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
        this.vehicleType = CarType.HATCHBACK.getVehicleType();
    }

    public double getPrice() {
        return basePrice + pricingStrategy.computePrice(2, basePrice);
    }
}
