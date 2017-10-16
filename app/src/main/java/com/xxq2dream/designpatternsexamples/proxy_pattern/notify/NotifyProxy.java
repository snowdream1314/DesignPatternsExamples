package com.xxq2dream.designpatternsexamples.proxy_pattern.notify;

import android.content.Context;
import android.os.Build;

/**
 * Description : 通知代理类
 * <p>
 * Author      : Created by xxq on 2017/10/16.
 */


public class NotifyProxy extends Notify {

    private Notify notify;

    public NotifyProxy (Context context) {
        super(context);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            notify = new NotifyHeadersUp(context);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            notify = new NotifyBig(context);
        } else {
            notify = new NotifyNormal(context);
        }
    }

    @Override
    public void send() {
        notify.send();
    }

    @Override
    public void cancel() {
        notify.cancel();
    }
}
