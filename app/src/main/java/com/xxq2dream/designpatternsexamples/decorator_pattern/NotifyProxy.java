package com.xxq2dream.designpatternsexamples.decorator_pattern;

import android.content.Context;
import android.os.Build;

import com.xxq2dream.designpatternsexamples.proxy_pattern.notify.Notify;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/17.
 */


public class NotifyProxy extends Notify{
    private NotifyDecorator notifyDecorator;

    public NotifyProxy (Context context) {
        super(context);

        Notify notify = new NotifyNormal(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            notifyDecorator = new NotifyHeadsUpDecorator(context, notify);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            notifyDecorator = new NotifyBigDecorator(context, notify);
        } else {
            notifyDecorator = new NotifyNormalDecorator(context, notify);
        }
    }

    @Override
    public void send() {
        notifyDecorator.send();
    }

    @Override
    public void cancel() {
        notifyDecorator.cancel();
    }
}
