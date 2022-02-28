package lld.zeta.service;

import lld.zeta.model.Locker;
import lld.zeta.model.Order;

import java.util.List;

public interface LockerHistoryService {

    List<Order> getHistory(Locker locker);

    void addHistory(Locker locker, Order order);
}
