package com.example.loginmvp;

public interface ActivityInterface {

    interface View{
        void onSuccess(String message);
        void onError(String message);
    }

    interface Presenter{
        void doLogin(String email, String password);
    }

}
