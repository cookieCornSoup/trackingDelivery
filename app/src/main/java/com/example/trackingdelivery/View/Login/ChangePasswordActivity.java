package com.example.trackingdelivery.View.Login;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trackingdelivery.Controller.Task.ChangePasswordTask;
import com.example.trackingdelivery.R;

public class ChangePasswordActivity extends AppCompatActivity {

    final Context context = this;
    private ChangePasswordTask mAuthTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        final EditText CHANGE_OLD_PASSWORD = (EditText) findViewById(R.id.change_oldpassword);
        final EditText CHANGE_NEW_PASSWORD = (EditText) findViewById(R.id.change_newpassword);
        final EditText CHANGE_NEW_PASSWORDCK = (EditText) findViewById(R.id.change_newpasswordCk);

        final Button CHANGE_PASSWORD_BUTTON = (Button) findViewById(R.id.reset_password_button);
        CHANGE_PASSWORD_BUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CHANGE_NEW_PASSWORD.equals(CHANGE_NEW_PASSWORDCK)) {
                    String oldPassword = CHANGE_OLD_PASSWORD.getText().toString();
                    String newPassword = CHANGE_NEW_PASSWORD.getText().toString();

                    mAuthTask = new ChangePasswordTask(oldPassword, newPassword);
                    FireMissilesDialogFragment fireMissilesDialogFragment;
                    mAuthTask.execute();
                    fireMissilesDialogFragment = new FireMissilesDialogFragment();

                } else if (!(CHANGE_NEW_PASSWORD.equals(CHANGE_NEW_PASSWORDCK))){
                    Toast.makeText(ChangePasswordActivity.this, "변경할 비밀번호와 확인 비밀번호가 서로 다릅니다.", Toast.LENGTH_LONG).show();
                }


            }
        });
    }


}