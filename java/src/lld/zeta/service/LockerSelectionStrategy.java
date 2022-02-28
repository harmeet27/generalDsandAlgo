package lld.zeta.service;

import lld.zeta.model.Locker;

import java.util.List;

public interface LockerSelectionStrategy {

    Locker select(List<Locker> lockers);
}
