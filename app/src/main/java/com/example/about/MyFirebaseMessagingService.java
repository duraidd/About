package com.example.about;

import android.app.NotificationManager;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        getFirebaseMsg(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }
    public void getFirebaseMsg(String title,String msg)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"myfirebase")
                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true);
        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(101,builder.build());
    }
}
