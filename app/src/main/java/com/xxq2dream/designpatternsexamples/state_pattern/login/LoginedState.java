package com.xxq2dream.designpatternsexamples.state_pattern.login;

import android.content.Context;
import android.widget.Toast;

/**
 * 登录状态
 *
 * @author xxq
 * @date 2017/10/31
 */
public class LoginedState implements UserState {

    @Override
    public void forward(Context context) {
        Toast.makeText(context, "转发", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void comment(Context context) {
        Toast.makeText(context, "评论", Toast.LENGTH_SHORT).show();

    }
}
