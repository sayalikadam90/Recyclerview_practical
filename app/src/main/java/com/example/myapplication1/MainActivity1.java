package com.example.myapplication1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends AppCompatActivity {

    Button btnadd;
    RecyclerView recyclerview;
    List<model> Namelist;

    AdapterName adapterName;
    model modelName;
    static final int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        btnadd = findViewById(R.id.btnadd);
        recyclerview = findViewById(R.id.recycleview);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setHasFixedSize(true);
        Namelist = new ArrayList<>();
        adapterName = new AdapterName(this, Namelist);
        recyclerview.setAdapter(adapterName);
        btnadd.setOnClickListener(new btnaddClickListener());

    }

    class btnaddClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity1.this,MainActivity2.class);
            startActivityForResult(intent,REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQUEST_CODE==requestCode){
            if(Activity.RESULT_OK==resultCode){
                String name=data.getStringExtra("Name");
                String call=data.getStringExtra("Call");
                String mail=data.getStringExtra("Email");
                String add=data.getStringExtra("Address");
                String dob=data.getStringExtra("dob");


                modelName=new model();
                modelName.setName(name);
                modelName.setCall(call);
                modelName.setEmail(mail);
                modelName.setAddress(add);
                modelName.setDob(dob);

                Namelist.add(modelName);
                adapterName.notifyDataSetChanged();


            }

        }
    }
}

