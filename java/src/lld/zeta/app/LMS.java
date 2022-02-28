package lld.zeta.app;

import lld.zeta.constants.AuthenticationMechanism;
import lld.zeta.model.Locker;
import lld.zeta.model.Order;

import java.util.List;

public interface LMS {

    Locker allocate(Order order, AuthenticationMechanism authenticationMechanism);

    void deallocate(Locker locker, AuthenticationMechanism authenticationMechanism, Integer token);

    List<Order> getOrders(Locker locker);

}


