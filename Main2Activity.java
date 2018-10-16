package com.appsplanet.test.saplmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private ArrayList<Data> marraylist;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        marraylist = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Main2Activity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        final DataAdapter dataAdapter = new DataAdapter(getApplicationContext(), marraylist);
        recyclerView.setAdapter(dataAdapter);

        RequestQueue requestQueue = Volley.newRequestQueue(Main2Activity.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://reqres.in/api/users?page=2",
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("success", response.toString());
                try {
                    JSONArray json = response.getJSONArray("data");
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject data1 = json.getJSONObject(i);
                        String id = data1.getString("id");
                        String firstname = data1.getString("first_name");
                        String lastname = data1.getString("last_name");
                        String avatar = data1.getString("avatar");

                        marraylist.add(new Data(id, firstname, lastname, avatar));
                        dataAdapter.notifyDataSetChanged();
                        Log.e("Data", id);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("erroe", error.toString());

            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}