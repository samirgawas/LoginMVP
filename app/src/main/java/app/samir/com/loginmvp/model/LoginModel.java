package app.samir.com.loginmvp.model;

import android.text.TextUtils;

import app.samir.com.loginmvp.presenter.LoginPresenter;
import app.samir.com.loginmvp.view.LoginView;

/**
 * Created by samir on 18-02-2018.
 */

public class LoginModel implements LoginPresenter {

    private LoginView mLoginView;

    public LoginModel(LoginView view) {

        mLoginView = view;
    }

    @Override
    public void performLogin(String name, String password) {
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(password)){
            mLoginView.loginValidation();
        }else if(name.equals("admin") && password.equals("admin")){
            mLoginView.loginSuccess();
        }else {
            mLoginView.loginFailed();
        }
    }
}
