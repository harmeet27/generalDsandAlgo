package lld.zeta.service.impl;

import lld.zeta.dao.LockerManagerDao;
import lld.zeta.model.Locker;
import lld.zeta.model.Order;
import lld.zeta.service.LockerSelectionStrategy;

import java.util.List;

public class LockerManagerService {
    private LockerManagerDao lockerManagerDao;
    private LockerSelectionStrategy lockerSelectionStrategy;

    public LockerManagerService(LockerManagerDao lockerManagerDao) {
        this.lockerManagerDao = lockerManagerDao;
    }

    public Locker getAvailableLocker(Order order) {
        List<Locker> lockers = lockerManagerDao.getLocker(order);
        return lockerSelectionStrategy.select(lockers);
    }

}
