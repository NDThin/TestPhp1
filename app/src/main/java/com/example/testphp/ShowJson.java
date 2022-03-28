package com.example.testphp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testphp1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowJson extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_json);
        textView = findViewById(R.id.userId);
        textView2 = findViewById(R.id.hoten);
        textView3 = findViewById(R.id.gioitinh);
        textView4 = findViewById(R.id.email);
        textView5 = findViewById(R.id.sdt);
        textView6 = findViewById(R.id.diachi);
        textView7 = findViewById(R.id.username);
        textView8 = findViewById(R.id.password);

        Intent iin= getIntent();

        String j =iin.getStringExtra("key");
        Log.d("TAG", "onCreate2: "+j);
        try {
            JSONObject jObject = new JSONObject(j);
            Log.d("TAG", "onCreate3: "+jObject);
            textView.setText(jObject.getString("id"));
            textView2.setText(jObject.getString("name"));
            textView3.setText(jObject.getString("GioiTinh"));
            textView4.setText(jObject.getString("Email"));
            textView5.setText(jObject.getString("SDT"));
            textView6.setText(jObject.getString("DiaChi"));
            textView7.setText(jObject.getString("UserName"));
            textView8.setText(jObject.getString("pass"));

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("TAG", "onCreate3: "+e.toString());
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }



    }

}