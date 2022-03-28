package com.example.testphp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testphp1.R;

public class GetData extends AppCompatActivity {

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
                String url = "http://192.168.1.22:80/tesPhp/show.php?details=" + json;
                showData show = new showData(url);
                show.execute();
                String a = show.getString();
                Log.d("TAG", "onClick: "+show.doInBackground());

                Intent intent = new Intent(GetData.this, ShowJson.class);
                intent.putExtra("key", a);
                startActivity(intent);
            }
        });
    }
}