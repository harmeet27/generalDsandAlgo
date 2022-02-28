package lld.zeta.app;

import lld.zeta.constants.AuthenticationMechanism;
import lld.zeta.model.Locker;
import lld.zeta.service.impl.LockerManagerService;
import lld.zeta.model.Order;
import lld.zeta.factory.AuthenticationFactory;
import lld.zeta.service.LockerHistoryService;

import java.util.List;

public class LMSApp implements LMS {

    private LockerManagerService lockerManagerService;
    private LockerHistoryService lockerHistoryService;
    private AuthenticationFactory authenticationFactory;

    public LMSApp(LockerManagerService lockerManagerService, LockerHistoryService lockerHistoryService, AuthenticationFactory authenticationFactory) {
        this.lockerManagerService = lockerManagerService;
        this.lockerHistoryService = lockerHistoryService;
        this.authenticationFactory = authenticationFactory;
    }

    @Override
    public Locker allocate(Order order, AuthenticationMechanism authenticationMechanism) {

        authenticationFactory.generate(authenticationMechanism, order.getUser());
        Locker locker = lockerManagerService.getAvailableLocker(order);
        locker.setOrder(order);
        lockerHistoryService.addHistory(locker, order);
        return locker;
    }

    @Override
    public void deallocate(Locker locker, AuthenticationMechanism authenticationMechanism, Integer token) {
        if (authenticationFactory.verify(authenticationMechanism, token, locker.getOrder().getUser())) {
            locker.setOrder(null);
        } else {
            throw new RuntimeException("Invalid verification");
        }

    }

    @Override
    public List<Order> getOrders(Locker locker) {
        return lockerHistoryService.getHistory(locker);
    }
}
