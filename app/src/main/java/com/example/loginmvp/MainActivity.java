package com.example.loginmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ActivityInterface.View {

    ActivityInterface.Presenter presenter;

    TextView email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter= new MainActivityPresenter(this);

        init();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Validate Strings
                String email1=email.getText().toString();
                String password1= password.getText().toString();

                if(TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)){
                    onError(getString(R.string.Fields_Required));
                }else{
                    presenter.doLogin(email1,password1);
                }
            }
        });

    }

    public void init(){
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        login= findViewById(R.id.login);
    }

    @Override
    public void onSuccess(String message) {

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onError(String message) {

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

    }
}