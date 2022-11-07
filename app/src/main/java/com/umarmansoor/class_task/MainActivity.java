package com.umarmansoor.class_task;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        rv = findViewById(R.id.rv);
        add = findViewById(R.id.add);
        ls = new ArrayList<>();

        adapter = new MyAdapter(ls, MainActivity.this);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);

        // database work
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new StringRequest(Request.Method.GET, "",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject res = new JSONObject(response);
                            if (res.getInt("code") == 1) {
                                JSONArray contacts = res.getJSONArray("contacts");
                                for (int i = 0; i < contacts.length(); ++i) {
                                    JSONObject obj = contacts.getJSONObject(i);
                                    ls.add(new MyModel(obj.getString("name"), obj.getString("phno"), obj.getString("address")));
                                    adapter.notifyDataSetChanged();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, res.getInt("msg"), Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "JSON error", Toast.LENGTH_SHORT).show();
            }
        }

        );
        queue.add(request);
    }

}