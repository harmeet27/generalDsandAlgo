package lld.zeta.selection;

import lld.zeta.model.Locker;
import lld.zeta.service.LockerSelectionStrategy;

import java.util.List;

public class RandomLockerSelectionStrategy implements LockerSelectionStrategy {

    @Override
    public Locker select(List<Locker> lockers) {
        for (Locker current : lockers) {
            if (current.isEmpty()) {
                return current;
            }
        }

        throw new RuntimeException("No locker available");
    }
}
