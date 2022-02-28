package lld.zeta.service;

public interface NotificationChannel<T> {

    void sendNotification(T message);
}
