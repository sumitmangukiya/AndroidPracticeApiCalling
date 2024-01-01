package com.cysm.androidpractice.Post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.cysm.androidpractice.Post.pModel.Model;
import com.cysm.androidpractice.databinding.ActivityRetrofitPostBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitPostActivity extends AppCompatActivity {

    ActivityRetrofitPostBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRetrofitPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnPostData.setOnClickListener(v -> {
            String strName, strJob;
            strName = binding.txtName.getText().toString();
            strJob = binding.txtJob.getText().toString();
            if (strName.isEmpty()) {
                Toast.makeText(RetrofitPostActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
            } else if (strJob.isEmpty()) {
                Toast.makeText(RetrofitPostActivity.this, "Please Enter Job", Toast.LENGTH_SHORT).show();
            } else {
                Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
                Call<Model> call = methods.getUserData(strName, strJob);
                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        String strOutput = "";
                        strOutput = "Id : " + response.body().getId();
                        strOutput = strOutput + "\nName : " + response.body().getName();
                        strOutput = strOutput + "\nJob : " + response.body().getJob();
                        strOutput = strOutput + "\nCreated At : " + response.body().getCreatedAt();
                        binding.lblOutput.setText(""+strOutput);
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Toast.makeText(RetrofitPostActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}