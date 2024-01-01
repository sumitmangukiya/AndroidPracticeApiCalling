package com.cysm.androidpractice.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cysm.androidpractice.Gson.gadapter.GFlagAdapter;
import com.cysm.androidpractice.Gson.gadapter.PostAdapter;
import com.cysm.androidpractice.Gson.gmodel.GFlags;
import com.cysm.androidpractice.Gson.gmodel.Post;
import com.cysm.androidpractice.R;
import com.cysm.androidpractice.databinding.ActivityGsonactivityBinding;
import com.google.gson.Gson;

import org.json.JSONArray;
import java.util.ArrayList;
import java.util.Arrays;

public class GSONActivity extends AppCompatActivity {


    ActivityGsonactivityBinding binding;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGsonactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        getData();
        getPost();
    }

    private void getData() {
        String url = "https://restcountries.com/v3.1/all?fields=name,flags";
        ArrayList<GFlags> flags = new ArrayList<>();
        GFlagAdapter flagAdapter;
        binding.recyclerViewGson.setLayoutManager(new LinearLayoutManager(GSONActivity.this));
        flagAdapter = new GFlagAdapter(GSONActivity.this, flags);
        binding.recyclerViewGson.setHasFixedSize(true);
        binding.recyclerViewGson.setAdapter(flagAdapter);
        RequestQueue queue = Volley.newRequestQueue(GSONActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                binding.progressBar.setVisibility(View.GONE);

                Gson gson = new Gson();
                GFlags[] data = gson.fromJson(response.toString(), GFlags[].class);
                flags.addAll(Arrays.asList(data));
                flagAdapter.notifyDataSetChanged();

            }
        }, error -> Toast.makeText(GSONActivity.this, "Fail to get the data..", Toast.LENGTH_SHORT).show());
        queue.add(jsonArrayRequest);


    }

    public void getPost() {
        ArrayList<Post>postArrayList = new ArrayList<>();
        binding.recyclerViewGson.setLayoutManager(new LinearLayoutManager(GSONActivity.this));
        binding.recyclerViewGson.setHasFixedSize(true);
        PostAdapter postAdapter = new PostAdapter(GSONActivity.this, postArrayList);
        binding.recyclerViewGson.setAdapter(postAdapter);

        String url = "https://jsonplaceholder.typicode.com/posts";
        RequestQueue queue = Volley.newRequestQueue(GSONActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                binding.progressBar.setVisibility(View.GONE);
                Gson gson = new Gson();

                Post[] data = gson.fromJson(response.toString(), Post[].class);
                postArrayList.addAll(Arrays.asList(data));
                postAdapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonArrayRequest);
    }
}