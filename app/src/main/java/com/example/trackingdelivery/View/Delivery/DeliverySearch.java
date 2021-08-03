package com.example.trackingdelivery.View.Delivery;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.trackingdelivery.R;
//https://www.journaldev.com/13639/retrofit-android-example-tutorial

/**
 *
 *
 */

public class DeliverySearch extends AppCompatActivity {

    String company = "";
    String companyName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_delivery);

        final EditText INVOICE_EDIT_TEXT =(EditText)findViewById(R.id.invoiceNumber);
        final TextView COMPANY_TEXT = (TextView) findViewById(R.id.company);




        Button companyselectorPost = (Button) findViewById(R.id.post);
        companyselectorPost.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                company = "kr.epost";
                COMPANY_TEXT.setText("우체국");
                companyName = "우체국";
            }
        });

        Button companyselectorCj = (Button) findViewById(R.id.cj);
        companyselectorCj.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                company = "kr.cjlogistics";
                COMPANY_TEXT.setText("cj 대한통운");
                companyName = "cj 대한통운";
            }
        });

        Button companyselectorhanjin = (Button) findViewById(R.id.hanjin);
        companyselectorhanjin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                company = "kr.hanjin";
                COMPANY_TEXT.setText("한진택배");
                companyName = "한진택배";

            }
        });

        Button sendBtn = (Button) findViewById(R.id.invoiceBtn);
        sendBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (company.equals("")){
                    Snackbar.make(view, "배송사를 선택해주세요", Snackbar.LENGTH_SHORT).show();
                }
                else if (!company.equals("")&&INVOICE_EDIT_TEXT.getText() == null){
                    Snackbar.make(view, "송장번호를 입력해주세요.", Snackbar.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(DeliverySearch.this, DeliveryDetail.class);
                    intent.putExtra("company", company);
                    intent.putExtra("invoiceNumber", String.valueOf(INVOICE_EDIT_TEXT.getText()));
                    intent.putExtra("companyName", companyName);

                    startActivity(intent);
                }

            }
        });
    }
}
