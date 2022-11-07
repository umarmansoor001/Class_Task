package com.umarmansoor.class_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add extends AppCompatActivity {

    Button button;
    EditText name,address,number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        button = findViewById(R.id.button);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        number = findViewById(R.id.number);


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String nam = name.getText().toString();
//                String num = number.getText().toString();
//                String addres = address.getText().toString();
//
//
//
//                Intent intent = new Intent();
//                intent.putExtra("NAM", nam);
//                intent.putExtra("NUM", num);
//                intent.putExtra("ADDRES", addres);
//                setResult(2, intent);
//                //onActivityResult(100,1, intent);
//                finish();
//            }
//
////            }
//        });
    }
}

