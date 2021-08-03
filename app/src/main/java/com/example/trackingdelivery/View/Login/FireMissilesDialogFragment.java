package com.example.trackingdelivery.View.Login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.example.trackingdelivery.R;

public class FireMissilesDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.cpwd_box_missage)
                .setNegativeButton(R.string.cpwd_box_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // 로그인 페이지로 이동 넣기(로그인 해제 토큰 날리기)



                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}