package com.example.testphp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testphp1.R;

public class MainActivity extends AppCompatActivity {

    EditText user, email, pass, hoten, gioitinh, sdt, diachi;
    Button signup, edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoten= (EditText) findViewById(R.id.HoTen);
        email= (EditText) findViewById(R.id.Email);
        sdt= (EditText) findViewById(R.id.SDT);
        user= (EditText) findViewById(R.id.UserName);
        pass= (EditText) findViewById(R.id.PassWord);
        gioitinh= (EditText) findViewById(R.id.GioiTinh);
        diachi= (EditText) findViewById(R.id.DiaChi);
        signup= (Button) findViewById(R.id.Login);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String json = String.format("{\"hoten\":\"%s\",\"gioitinh\":\"%s\",\"email\":\"%s\",\"diachi\":\"%s\",\"sdt\":\"%s\",\"user\":\"%s\",\"pass\":\"%s\"}", hoten.getText(), gioitinh.getText(), email.getText(), sdt.getText(), diachi.getText(), user.getText(), pass.getText());
                String url = "http://192.168.1.22:80/tesPhp/sendemail.php?details=" + json;
                new sendEmail(url).execute();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });
        edit =findViewById(R.id.Edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GetData.class);
                startActivity(intent);
            }
        });
    }
}
