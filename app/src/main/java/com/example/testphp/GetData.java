package com.example.testphp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testphp1.R;

public class GetData extends AppCompatActivity {

    public String string;
    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        editText = findViewById(R.id.userid);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = String.format("{\"id\":\"%s\"}", editText.getText());
                String url = "http://192.168.1.24:80/tesPhp/show.php?details=" + json;
                showData show = new showData(GetData.this, url);
                show.execute(GetData.this);
            }
        });
    }
}