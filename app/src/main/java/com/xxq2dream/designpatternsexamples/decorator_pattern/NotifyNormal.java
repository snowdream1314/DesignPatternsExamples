package com.xxq2dream.designpatternsexamples.decorator_pattern;

import android.app.Notification;
import android.content.Context;

import com.xxq2dream.designpatternsexamples.proxy_pattern.notify.Notify;

/**
 * Description : 普通通知
 * <p>
 * Author      : Created by xxq on 2017/10/17.
 */


public class NotifyNormal extends Notify {

    public NotifyNormal(Context context) {
        super(context);
    }

    @Override
    public void send() {
        Notification notification = builder.build();
        notificationManager.notify(0, notification);
    }

    @Override
    public void cancel() {
        notificationManager.cancel(0);
    }

}
