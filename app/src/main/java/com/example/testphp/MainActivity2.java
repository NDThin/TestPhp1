package com.example.testphp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testphp1.R;

public class MainActivity2 extends AppCompatActivity {

    Button Edit, Delete, show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Edit = findViewById(R.id.edit);
        Delete = findViewById(R.id.delete);
        show = findViewById(R.id.show);

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(MainActivity2.this, EditActivity.class);
                startActivity(inten);
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(MainActivity2.this, GetData.class);
                startActivity(inten);
            }
        });

//        Delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                String json = String.format("{\"hoten\":\"%s\",\"gioitinh\":\"%s\",\"email\":\"%s\",\"diachi\":\"%s\",\"sdt\":\"%s\",\"user\":\"%s\",\"pass\":\"%s\"}", hoten.getText(), gioitinh.getText(), email.getText(), sdt.getText(), diachi.getText(), user.getText(), pass.getText());
////                String url = "http://192.168.1.6:80/testPhp/sendemail.php?details=" + json;
////                new sendEmail(url).execute();
//
//            }
//        });
    }
}