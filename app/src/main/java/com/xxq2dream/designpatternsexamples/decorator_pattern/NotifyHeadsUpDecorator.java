package com.xxq2dream.designpatternsexamples.decorator_pattern;

import android.content.Context;
import android.widget.RemoteViews;

import com.xxq2dream.designpatternsexamples.R;
import com.xxq2dream.designpatternsexamples.proxy_pattern.notify.Notify;

/**
 * Description :
 * <p>
 * Author      : Created by xxq on 2017/10/17.
 */


public class NotifyHeadsUpDecorator extends NotifyDecorator {

    public NotifyHeadsUpDecorator(Context context, Notify notify) {
        super(context, notify);
    }

    @Override
    public void send() {
        builder.setContent(new RemoteViews(context.getPackageName(), R.layout.layout_notify_normal));
        builder.setCustomBigContentView(new RemoteViews(context.getPackageName(), R.layout.layout_notify_normal));
        builder.setCustomHeadsUpContentView(new RemoteViews(context.getPackageName(), R.layout.layout_notify_normal));
        super.send();
    }
}
