package com.umarmansoor.class_task;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    List<MyModel> ls;
    MyAdapter adapter;
    ImageView add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        add = findViewById(R.id.add);
        ls = new ArrayList<>();



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, add.class);
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2)
        {
            String name = data.getStringExtra("NAM");
            String number = data.getStringExtra("NUM");
            String address = data.getStringExtra("ADDRES");

            ls.add(new MyModel(name,number,address));
            adapter=new MyAdapter(ls,MainActivity.this);
            RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);
            rv.setLayoutManager(lm);
            rv.setAdapter(adapter);
        }
    }
}