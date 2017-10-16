package com.xxq2dream.designpatternsexamples.proxy_pattern.notify;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.xxq2dream.designpatternsexamples.R;
import com.xxq2dream.designpatternsexamples.proxy_pattern.NotifyActivity;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/16.
 */


public abstract class Notify {

    protected Context context;
    protected NotificationManager notificationManager;
    protected NotificationCompat.Builder builder;

    public Notify(Context context) {
        this.context = context;
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(PendingIntent.getActivity(context, 0,
                        new Intent(context, NotifyActivity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT));
    }

    /**
     * 发送一条通知
     */
    public abstract void send();

    /**
     * 取消一条通知
     */
    public abstract void cancel();
}
