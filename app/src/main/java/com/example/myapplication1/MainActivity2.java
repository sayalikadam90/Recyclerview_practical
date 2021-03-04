package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText Name3;
    EditText Call3;
    EditText Email3;
    EditText Address3;
    EditText dob3;
    Button btnnext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Name3=findViewById(R.id.recycle1);
        Call3=findViewById(R.id.recycle2);
        Email3=findViewById(R.id.recycle3);
        Address3=findViewById(R.id.recycle4);
        dob3=findViewById(R.id.recycle6);
        btnnext=findViewById(R.id.recycle5);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MainActivity1.class);
                String name1=Name3.getText().toString().trim();
                String call1=Call3.getText().toString().trim();
                String email1=Email3.getText().toString().trim();
                String add1=Address3.getText().toString().trim();
                String dob1=dob3.getText().toString().trim();


                intent.putExtra("Name",name1);
                setResult(Activity.RESULT_OK,intent);
                intent.putExtra("Call",call1);
                intent.putExtra("Email",email1);
                intent.putExtra("Address",add1);
                intent.putExtra("dob",dob1);
                finish();

            }
        });
    }
}