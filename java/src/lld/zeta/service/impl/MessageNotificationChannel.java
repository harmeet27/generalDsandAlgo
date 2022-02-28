package lld.zeta.service.impl;

import lld.zeta.service.NotificationChannel;

public class MessageNotificationChannel implements NotificationChannel<String> {

    @Override
    public void sendNotification(String message) {
        System.out.println(message + " sent as message to mobile");
    }
}
