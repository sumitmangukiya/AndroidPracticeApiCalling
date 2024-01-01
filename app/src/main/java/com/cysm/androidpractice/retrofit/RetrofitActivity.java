package com.cysm.androidpractice.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cysm.androidpractice.databinding.ActivityRetrofitBinding;
import com.cysm.androidpractice.retrofit.radapter.RetrofitAdapter;
import com.cysm.androidpractice.retrofit.rmodel.RetrofitModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetrofitActivity extends AppCompatActivity {

    ActivityRetrofitBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRetrofitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getRequest();
    }

    private void getRequest() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetrofitModel>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetrofitModel>>() {
            @Override
            public void onResponse(Call<List<RetrofitModel>> call, Response<List<RetrofitModel>> response) {
                binding.progressBar.setVisibility(View.GONE);
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetrofitModel>> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                Toast.makeText(RetrofitActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<RetrofitModel> photoList) {
        RetrofitAdapter adapter = new RetrofitAdapter(photoList, RetrofitActivity.this);
        binding.recyclerViewRetrofit.setLayoutManager(new LinearLayoutManager(RetrofitActivity.this));
        binding.recyclerViewRetrofit.setHasFixedSize(true);
        binding.recyclerViewRetrofit.setAdapter(adapter);
    }
}