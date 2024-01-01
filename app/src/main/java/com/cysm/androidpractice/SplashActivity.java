package com.cysm.androidpractice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.cysm.androidpractice.MainActivity;
import com.cysm.androidpractice.databinding.ActivitySplashBinding;
import com.cysm.androidpractice.task.TaskActivity;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, TaskActivity.class));
            finish();
        }, 3000);
    }

}