package com.example.trackingdelivery.View.Login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.trackingdelivery.R;

@SuppressLint("Registered")
public class MainLoginActivity extends AppCompatActivity {
    public static Activity MainLoginActivity;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        {
            MainLoginActivity = MainLoginActivity.this;
            final Button KAKAO_EMAIL_SIGN_IN_BUTTON = (Button) findViewById(R.id.kakao_email_sign_in_button);
            final Button NAVER_SIGN_IN_button = (Button) findViewById(R.id.naver_sign_in_button);
            final Button FACEBOOK_SIGN_UP_BUTTON = (Button) findViewById(R.id.facebook_sign_in_button);
            final TextView EMAIL_LOGIN_BTN = (TextView) findViewById(R.id.email_login_btn);
            final TextView EMAIL_SIGN_UP_BTN = (TextView) findViewById(R.id.email_sign_up_btn);

            KAKAO_EMAIL_SIGN_IN_BUTTON.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //kakao 추가
                    Snackbar.make(v, "카카오톡", Snackbar.LENGTH_SHORT).show();
                }
            });

            NAVER_SIGN_IN_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //네이버 추가
                    Snackbar.make(v, "네이버", Snackbar.LENGTH_SHORT).show();
                }
            });

            FACEBOOK_SIGN_UP_BUTTON.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //facebook 추가
                    Snackbar.make(v, "페이스북", Snackbar.LENGTH_SHORT).show();
                }
            });

            EMAIL_LOGIN_BTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //이메일 로그인
                    intent = new Intent(MainLoginActivity.this, EmailLoginActivity.class);
                    startActivity(intent);
                }
            });


            EMAIL_SIGN_UP_BTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //이메일 회원가입
                    /*intent = new Intent(MainLoginActivity.this, EmailSignUpActivity.class);
                    startActivity(intent);*/
                }
            });

        }

    }
}
