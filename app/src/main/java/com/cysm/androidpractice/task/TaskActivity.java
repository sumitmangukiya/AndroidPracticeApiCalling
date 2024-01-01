package com.cysm.androidpractice.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cysm.androidpractice.R;
import com.cysm.androidpractice.task.tadapter.YourAdapter;
import com.cysm.androidpractice.task.tmodel.ApiResponse;
import com.cysm.androidpractice.task.tmodel.Data;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TaskActivity extends AppCompatActivity {
    public static final String TAG = "TaskActivity";
    private RecyclerView recyclerView;
    private YourAdapter adapter;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new YourAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://general.63-141-249-130.plesk.page/").addConverterFactory(GsonConverterFactory.create()).build();

        apiService = retrofit.create(ApiService.class);

        fetchData();
    }

    private void fetchData() {
        Call<ApiResponse> call = apiService.getData();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.e(TAG, "onResponse: " + response.message());
                if (response.isSuccessful()) {
                    Log.e(TAG, "onResponse: " + response);
                    ApiResponse apiResponse = response.body();
                    Log.e(TAG, "onResponse: " + response.body());
                    List<Data> dataList = apiResponse.data;
                    adapter.setData(dataList);
                } else {
                    Toast.makeText(TaskActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(TaskActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
