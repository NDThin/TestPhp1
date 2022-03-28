package com.example.testphp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testphp1.R;

public class EditActivity extends AppCompatActivity {
    EditText  email, hoten, gioitinh, sdt, diachi, user, pass;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        hoten= (EditText) findViewById(R.id.HoTen);
        email= (EditText) findViewById(R.id.Email);
        sdt= (EditText) findViewById(R.id.SDT);
        diachi= (EditText) findViewById(R.id.UserName);
        gioitinh= (EditText) findViewById(R.id.GioiTinh);
        user= (EditText) findViewById(R.id.UserName);
        save = findViewById(R.id.Save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = String.format("{\"hoten\":\"%s\",\"gioitinh\":\"%s\",\"email\":\"%s\",\"diachi\":\"%s\",\"sdt\":\"%s\",\"user\":\"%s\"}", hoten.getText(), gioitinh.getText(), email.getText(), diachi.getText(), sdt.getText(),user.getText());
                String url = "http://192.168.1.6:80/tesPhp/edit.php?details=" + json;
                new sendEmail(url).execute();
            }
        });
    }
}