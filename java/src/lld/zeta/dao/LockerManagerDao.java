package lld.zeta.dao;

import lld.zeta.constants.Location;
import lld.zeta.model.Locker;
import lld.zeta.model.Order;
import lld.zeta.constants.PackageType;

import java.util.List;
import java.util.Map;

public class LockerManagerDao {

    private Map<Location, Map<PackageType, List<Locker>>> lockerRecords;

    public List<Locker> getLocker(Order order) {
        //order contains location.
        List<Locker> lockers = lockerRecords.get(order.getLocation()).get(order.getPackageType());
        if (lockers.isEmpty())
            throw new RuntimeException("No lockers are available for location" + order.getLocation());

        return lockers;
    }


}
