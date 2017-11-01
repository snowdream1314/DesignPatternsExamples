package com.xxq2dream.designpatternsexamples.state_pattern.login;

import android.content.Context;

/**
 * description
 *
 * @author xxq
 * @date 2017/10/31
 */
public interface UserState {

    /**
     * 转发
     *
     * @param context
     */
    public void forward(Context context);

    /**
     * 评论
     *
     * @param context
     */
    public void comment(Context context);
}
