package app.samir.com.loginmvp.activities;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import app.samir.com.loginmvp.R;
import app.samir.com.loginmvp.model.LoginModel;
import app.samir.com.loginmvp.presenter.LoginPresenter;
import app.samir.com.loginmvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{

    private TextInputEditText textName;
    private TextInputEditText textPassword;
    private Button buttonLogin;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.name);
        textPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.login);
        mLoginPresenter = new LoginModel(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name  = textName.getText().toString();
                String pass  = textPassword.getText().toString();
                mLoginPresenter.performLogin(name, pass);
            }
        });
    }

    @Override
    public void loginValidation() {
        Toast.makeText(this, "Not Validated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }
}
