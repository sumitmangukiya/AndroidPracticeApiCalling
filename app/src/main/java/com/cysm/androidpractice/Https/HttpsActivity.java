package com.cysm.androidpractice.Https;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.cysm.androidpractice.Https.hadapter.HAdapter;
import com.cysm.androidpractice.Https.hmodel.Todos;
import com.cysm.androidpractice.R;
import com.cysm.androidpractice.databinding.ActivityHttpsBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpsActivity extends AppCompatActivity {
    public static final String TAG = "HttpsActivity";
    ActivityHttpsBinding binding;

    ArrayList<Todos> todosArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHttpsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String apiUrl = "https://jsonplaceholder.typicode.com/todos";
        new ApiCallTask().execute(apiUrl);
    }

    private class ApiCallTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String urlString = params[0];
            try {
                binding.progressBar.setVisibility(View.VISIBLE);
                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                try {
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(5000);

                    int responseCode = urlConnection.getResponseCode();

                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        StringBuilder response = new StringBuilder();
                        String line;

                        while ((line = in.readLine()) != null) {
                            response.append(line);
                        }

                        in.close();
                        return response.toString();
                    } else {
                        Log.e(TAG, "HTTP error code: " + responseCode);
                    }
                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e(TAG, "Error making HTTP request", e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            binding.progressBar.setVisibility(View.GONE);
            if (result != null) {
                Type listType = new TypeToken<List<Todos>>() {
                }.getType();
                List<Todos> todosList = new Gson().fromJson(result, listType);
                todosArrayList.addAll(todosList);
                Toast.makeText(HttpsActivity.this, "" + todosArrayList.size(), Toast.LENGTH_SHORT).show();

                binding.recyclerViewHttps.setLayoutManager(new LinearLayoutManager(HttpsActivity.this));
                binding.recyclerViewHttps.setAdapter(new HAdapter(HttpsActivity.this, todosArrayList));
                binding.recyclerViewHttps.setHasFixedSize(true);
            } else {
                Toast.makeText(HttpsActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
