package com.example.dowmloadjson;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadJSON extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... strings) {
        URL url=null;
        HttpURLConnection urlConnection=null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while (line!=null){
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
            return stringBuilder.toString();

        }catch (Exception e){

        }finally {
            if(urlConnection!=null) {
                urlConnection.disconnect();
            }
        }



        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("my_Res",s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            String cod = jsonObject.getString("cod");
            JSONArray jsonArray = jsonObject.getJSONArray("list");
            JSONObject main = jsonArray.getJSONObject(0);
            JSONObject kek = main.getJSONObject("main");
            String lol = kek.getString("temp");
            Log.i("my_res",cod);
            Log.i("mt_res",lol);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
