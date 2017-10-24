package com.xxq2dream.designpatternsexamples.decorator_pattern;

import android.content.Context;

import com.xxq2dream.designpatternsexamples.proxy_pattern.notify.Notify;

/**
 * Description : Notify类的抽象装饰者
 * <p>
 * Author      : Created by xxq on 2017/10/17.
 */


public abstract class NotifyDecorator extends Notify {
    private Notify notify;

    public NotifyDecorator (Context context, Notify mNotify) {
        super(context);
        this.notify = mNotify;
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
