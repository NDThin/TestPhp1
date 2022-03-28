package com.example.testphp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.testphp1.R;

public class ShowJson extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_json);
        textView = findViewById(R.id.textView);
        Intent iin= getIntent();

        String j =iin.getStringExtra("key");
        Log.d("TAG", "onCreate: "+j);
        textView.setText(j);

    }
}