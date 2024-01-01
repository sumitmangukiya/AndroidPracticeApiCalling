package com.cysm.androidpractice.volly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cysm.androidpractice.databinding.ActivityVolleyBinding;
import com.cysm.androidpractice.volly.vadapter.FlagAdapter;
import com.cysm.androidpractice.volly.vmodel.Flag;

import java.util.ArrayList;


public class VolleyActivity extends AppCompatActivity {
    String url = "https://restcountries.com/v3.1/all?fields=name,flags";
    public static final String TAG = "VolleyActivity";
    ArrayList<Flag> flags = new ArrayList<>();

    ActivityVolleyBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVolleyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getData();
    }

    private void getData() {
        RequestQueue queue = Volley.newRequestQueue(VolleyActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                binding.progressBar.setVisibility(View.GONE);
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject responseObj = response.getJSONObject(i);
                        Log.e(TAG, "onResponse: " + response);
                        flags.add(new Flag(responseObj.getJSONObject("flags").getString("png"),responseObj.getJSONObject("name").getString("common")));
                        binding.recyclerViewVolley.setAdapter(new FlagAdapter(VolleyActivity.this, flags));
                        binding.recyclerViewVolley.setHasFixedSize(true);
                        binding.recyclerViewVolley.setLayoutManager(new LinearLayoutManager(VolleyActivity.this));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, error -> Toast.makeText(VolleyActivity.this, "Fail to get the data..", Toast.LENGTH_SHORT).show());
        queue.add(jsonArrayRequest);
    }
}