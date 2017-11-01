package com.xxq2dream.designpatternsexamples.state_pattern.login;

import android.content.Context;

/**
 * 用户接口和状态管理类
 *
 * @author xxq
 * @date 2017/10/31
 */
public class LoginContext {

    /**
     * 用户状态，默认为登录状态
     */
    UserState userState = new LoginedState();

    /**
     * 单例
     */
    static LoginContext loginContext = new LoginContext();

    private LoginContext() {

    }

    public LoginContext getLoginContext() {
        return loginContext;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public void forward(Context context) {
        userState.forward(context);
    }

    public void comment(Context context) {
        userState.comment(context);
    }
}
