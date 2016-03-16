package com.example.u.bikebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText idCardEditText, passwordEditText;
    private String idCardString, passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BindWidget
        bindWidget();

    }   // Main Method

    private void bindWidget() {

        idCardEditText = (EditText) findViewById(R.id.editText3);
        passwordEditText = (EditText) findViewById(R.id.editText4);

    }

    public void clickSignInMain(View view) {

        idCardString = idCardEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //CheckSpace
        if (idCardString.equals("") || passwordString.equals("")) {
            //Have Space
            myAlert("โปรดกรอกข้อมูลให้ครบทุกช่องค่ะ");
        }

    }   // ClickSignInMain

    private void myAlert(String strAlert) {

        Toast.makeText(MainActivity.this, strAlert, Toast.LENGTH_LONG.).show();

    }


    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

}   // Main Class
