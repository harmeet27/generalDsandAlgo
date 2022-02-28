package lld.zeta.model;

import lld.zeta.constants.Location;
import lld.zeta.constants.PackageType;

public class Order {
    private User user;
    private String item;
    private Location location;
    private PackageType packageType;

    public Order(User user, String item, Location location, PackageType packageType) {
        this.user = user;
        this.item = item;
        this.location = location;
        this.packageType = packageType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
