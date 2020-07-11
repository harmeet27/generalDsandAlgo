package com.preparation.companywise.flipKar.model;

public enum CarType {

    SUV("SUV"), HATCHBACK("HATCHBACK"), SEDAN("SEDAN");
    private String vehicleType;

    CarType(String vehicleType) {
        vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
