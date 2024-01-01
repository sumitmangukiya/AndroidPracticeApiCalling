package com.cysm.androidpractice.Gsonobject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cysm.androidpractice.Gsonobject.gadapter.UserAdapter;
import com.cysm.androidpractice.Gsonobject.gmodel.Data;
import com.cysm.androidpractice.Gsonobject.gmodel.User;
import com.cysm.androidpractice.databinding.ActivityGsonObjectBinding;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class GsonObjectActivity extends AppCompatActivity {

    ActivityGsonObjectBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGsonObjectBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getApi();
    }

    void getApi() {
        ArrayList<Data> dataArrayList = new ArrayList<>();
        UserAdapter adapter;
        binding.recyclerViewGsonObject.setLayoutManager(new GridLayoutManager(this, 1));
        binding.recyclerViewGsonObject.setHasFixedSize(true);
        adapter = new UserAdapter(this, dataArrayList);
        binding.recyclerViewGsonObject.setAdapter(adapter);

        String url = "https://reqres.in/api/users";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                binding.progressBar.setVisibility(View.GONE);
                Gson gson = new Gson();
                User data = gson.fromJson(String.valueOf(response), User.class);
                dataArrayList.addAll(Arrays.asList(data.data));
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}