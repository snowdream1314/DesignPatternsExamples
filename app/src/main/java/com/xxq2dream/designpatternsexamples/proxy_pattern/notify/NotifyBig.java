package com.xxq2dream.designpatternsexamples.proxy_pattern.notify;

import android.app.Notification;
import android.content.Context;
import android.widget.RemoteViews;

import com.xxq2dream.designpatternsexamples.R;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/16.
 */


public class NotifyBig extends Notify {

    public NotifyBig (Context context) {
        super(context);
    }

    @Override
    public void send() {
        builder.setContent(new RemoteViews(context.getPackageName(), R.layout.layout_notify_normal));
        builder.setCustomBigContentView(new RemoteViews(context.getPackageName(), R.layout.layout_notify_normal));
        Notification notification = builder.build();
        notificationManager.notify(0, notification);
    }

    @Override
    public void cancel() {
        notificationManager.cancel(0);
    }
}
