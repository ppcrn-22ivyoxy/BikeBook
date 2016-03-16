package com.example.u.bikebook;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    // Explicit
    private EditText idCardEditText, passwordEditText;
    private String idCardString, passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Bind Widget
        bindWidget();

    }   // Main Method

    private void bindWidget() {
        idCardEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);
    }

    public void clickSignUpSign(View view) {

        idCardString = idCardEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();


        // Check Space
        if (idCardString.equals("") || passwordString.equals("")) {
            // Have Space
            myToast("กรุณากรอกข้อมูลให้ครบค่ะ");
        } else {
            // No Space
            checkIDcard();
        }

    }   // clickSignUp

    private void checkIDcard() {

        if (idCardString.length() == 13) {
            // Id card True
            comfirmData(idCardString, passwordString);

        } else {
            // Id card False
            myToast("รหัสบัตรประชาชนไม่ถูกต้องค่ะ");


        }

    } // ChickIDcard

    private void comfirmData(String idCardString, String passwordString) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.icon_myaccount);
        builder.setTitle("โปรดตรวจสอบข้อมูล");
        builder.setMessage("รหัสบัตรประชาชน = " + idCardString + "\n" +
                "Password = " + passwordString);
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                updateDataToServer();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();

    }   // confirmData

    private void updateDataToServer() {



    }   // updatedatatoserver

    private void myToast(String strToase) {

        Toast.makeText(SignUpActivity.this, strToase, Toast.LENGTH_SHORT).show();

    }

}   // Main Class
