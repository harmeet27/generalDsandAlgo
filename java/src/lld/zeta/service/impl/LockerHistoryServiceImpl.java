package lld.zeta.service.impl;

import lld.zeta.model.Locker;
import lld.zeta.model.Order;
import lld.zeta.service.LockerHistoryService;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LockerHistoryServiceImpl implements LockerHistoryService {

    private Map<Locker, List<Order>> lockerHistoryMap;

    @Override
    public List<Order> getHistory(Locker locker) {
        return lockerHistoryMap.get(locker);
    }

    @Override
    public void addHistory(Locker locker, Order order) {
        List<Order> orders;
        if (lockerHistoryMap.containsKey(locker)) {
            orders = lockerHistoryMap.get(locker);
        } else {
            orders = new LinkedList<>();
        }
        orders.add(order);
        lockerHistoryMap.put(locker, orders);
    }
}
