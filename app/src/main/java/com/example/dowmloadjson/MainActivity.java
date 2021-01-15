package com.example.dowmloadjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://samples.openweathermap.org/data/2.5/forecast?q=München,DE&appid=439d4b804bc8187953eb36d2a8c26a02";
        DownloadJSON json = new DownloadJSON();
        try {
            json.execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}