package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class recyclerview3 extends AppCompatActivity {

    TextView text5;
    TextView text6;
    TextView text7;
    TextView text8;
    TextView text9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview3);

        text5=findViewById(R.id.name1);
        text6=findViewById(R.id.mob1);
        text7=findViewById(R.id.email1);
        text8=findViewById(R.id.address1);
        text9=findViewById(R.id.dob1);

       model modelname=(model) getIntent().getSerializableExtra("show");

       text5.setText(modelname.getName());
       text6.setText(modelname.getCall());
       text7.setText(modelname.getEmail());
       text8.setText(modelname.getAddress());
       text9.setText(modelname.getDob());

       // Intent intent=getIntent();
        //String name1=intent.getStringExtra("Name");
        //String call1=intent.getStringExtra("Call");
        //String email1=intent.getStringExtra("Email");
        //String address1=intent.getStringExtra("Address");
        //String dob1=intent.getStringExtra("dob");

       // text5.setText("Name : "+name1);
        //text6.setText("Call : "+call1);
        //text7.setText("Email : "+email1);
        //text8.setText("Address"+address1);
        //text9.setText("dob"+dob1);



    }
}