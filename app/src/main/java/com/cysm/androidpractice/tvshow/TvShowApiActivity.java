package com.cysm.androidpractice.tvshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.cysm.androidpractice.R;
import com.cysm.androidpractice.databinding.ActivityTvShowApiBinding;
import com.cysm.androidpractice.tvshow.tadapter.TvShowAdapter;
import com.cysm.androidpractice.tvshow.tmodel.TvShowModel;
import com.google.gson.Gson;
import com.kaopiz.kprogresshud.KProgressHUD;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;

public class TvShowApiActivity extends AppCompatActivity {

    KProgressHUD progress;
    ActivityTvShowApiBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTvShowApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        KProgressHUD.create(TvShowApiActivity.this)
//                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
//                .setLabel("Please wait")
//                .setDetailsLabel("Downloading data")
//                .setCancellable(true)
//                .setAnimationSpeed(2)
//                .setDimAmount(0.5f)
//                .show();
        getShow();
        progress = KProgressHUD.create(this);
        progress.setDimAmount(0.5f);
        progress.show();

    }

    private void getShow() {
        String url = "https://api.tvmaze.com/search/shows?q=postman";
        ArrayList<TvShowModel> tvShowModels = new ArrayList<>();
        binding.recyclerViewTvShow.setHasFixedSize(true);
        binding.recyclerViewTvShow.setLayoutManager(new GridLayoutManager(this, 2));

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(TvShowApiActivity.this, "" + response.length(), Toast.LENGTH_SHORT).show();
                binding.progressBar.setVisibility(View.GONE);
                progress.dismiss();
                Gson gson = new Gson();
                TvShowModel[] data = gson.fromJson(response.toString(), TvShowModel[].class);
                tvShowModels.addAll(Arrays.asList(data));
                binding.recyclerViewTvShow.setAdapter(new TvShowAdapter(TvShowApiActivity.this, tvShowModels));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(TvShowApiActivity.this, "" + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}