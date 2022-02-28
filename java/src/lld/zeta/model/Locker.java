package lld.zeta.model;

import java.util.Objects;

public class Locker {
    private int lockerId;
    private Order order;

    public Locker(int lockerId) {
        this.lockerId = lockerId;
    }

    public boolean isEmpty() {
        if (order == null) {
            return true;
        }
        return false;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getLockerId() {
        return lockerId;
    }

    public boolean equals(Object other) {
        Locker otherLocker = (Locker) other;
        return otherLocker.getLockerId() == this.lockerId;
    }

    public int hashCode() {
        return Objects.hash(this.lockerId);
    }

}
