package com.example.testphp;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class sendEmail extends AsyncTask<Void, Void, String> {
    String url;
    public sendEmail(String url){
        this.url = url;
    }

    @Override
    protected String doInBackground(Void... params) {

        String str = url;
        URLConnection urlConn = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(str);
            urlConn = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();
            Log.d("TAG", "doInBackground: "+url+" "+stringBuffer);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            Log.d("TAG", "doInBackground: "+stringBuffer);
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
        if (response != null) {
            if (response.equalsIgnoreCase("sent")) {
//                Intent intent = new Intent(ForgotPasswordActivity.this, ChangePasswordActivity.class);
//                intent.putExtra("token", token);
//                intent.putExtra("email", email);
//                startActivity(intent);
            }
        }
    }
}
