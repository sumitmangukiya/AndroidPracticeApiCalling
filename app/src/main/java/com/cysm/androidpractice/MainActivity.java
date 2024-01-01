package com.cysm.androidpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.cysm.androidpractice.Gson.GSONActivity;
import com.cysm.androidpractice.Gsonobject.GsonObjectActivity;
import com.cysm.androidpractice.Https.HttpsActivity;
import com.cysm.androidpractice.Post.RetrofitPostActivity;
import com.cysm.androidpractice.databinding.ActivityMainBinding;
import com.cysm.androidpractice.retrofit.RetrofitActivity;
import com.cysm.androidpractice.tvshow.TvShowApiActivity;
import com.cysm.androidpractice.volly.VolleyActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.jsonArrayRequest.setOnClickListener(v -> {
            startActivity(new Intent(this, VolleyActivity.class));
        });

        binding.gsonArrayRequest.setOnClickListener(v -> {
            startActivity(new Intent(this, GSONActivity.class));
        });

        binding.gsonObjectRequest.setOnClickListener(v -> {
            startActivity(new Intent(this, GsonObjectActivity.class));
        });

        binding.retrofitRequest.setOnClickListener(v -> {
            startActivity(new Intent(this, RetrofitActivity.class));
        });

        binding.httpsRequest.setOnClickListener(v -> {
            startActivity(new Intent(this, HttpsActivity.class));
        });

        binding.retrofitPostRequest.setOnClickListener(v -> {
            startActivity(new Intent(this, RetrofitPostActivity.class));

        });

        binding.tvShowRequest.setOnClickListener(v -> {
            startActivity(new Intent(this, TvShowApiActivity.class));
        });


        shineAnimation();


    }

    private void shineAnimation() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.left_right);
        binding.shine.startAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                binding.shine.startAnimation(anim);
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

}