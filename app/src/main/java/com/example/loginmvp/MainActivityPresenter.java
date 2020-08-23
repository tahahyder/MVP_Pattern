package com.example.loginmvp;

public class MainActivityPresenter implements ActivityInterface.Presenter {

    ActivityInterface.View view;

    public MainActivityPresenter(ActivityInterface.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {

        // email taha@hotmail.com
        // password 12345678

        if(email.equals("taha@hotmail.com") && password.equals("12345678")){
            view.onSuccess("Successful");
        }else{
            view.onError("Wrong Email or Password");
        }

    }

}
