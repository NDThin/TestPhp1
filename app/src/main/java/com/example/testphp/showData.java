package com.example.testphp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class showData extends AsyncTask<Context, Void, String> {
    String url;
    public showData(Context context, String url){
        this.context = context;
        this.url = url;
    }

    Context context;
    String string;
    StringBuffer stringBuffer;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Context... params) {

        String str = url;
        URLConnection urlConn = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(str);
            urlConn = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            Intent intent = new Intent(params[0], ShowJson.class);
            intent.putExtra("key", stringBuffer.toString());
            params[0].startActivity(intent);
            Log.d("TAG", "doInBackground: "+stringBuffer.toString());
            return stringBuffer.toString();
        }
        catch (Exception ex) {
            Log.e("App", "cannot connect", ex);
            return null;
        }
        finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onPostExecute(String response) {
    }

}
