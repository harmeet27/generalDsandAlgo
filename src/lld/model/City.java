package lld.model;

public enum City {

    HYDERABAD("HYDERABAD"), DELHI("DELHI"), BANGALORE("BANGALORE"), GURGAON("GURGAON"), MUMBAI("MUMBAI");
    private String cityName;

    City(String city) {
        cityName = city;
    }

    public String getCityName() {
        return cityName;
    }


    }
