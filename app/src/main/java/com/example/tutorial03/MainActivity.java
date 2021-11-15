package com.example.tutorial03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText edunm, edpass;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login();
    }
    void Login() {
        edunm = (EditText) findViewById(R.id.edusernm);
        edpass = (EditText) findViewById(R.id.edpassword);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Patterns.EMAIL_ADDRESS.matcher(edunm.getText().toString()).matches()){
                    Toast.makeText(MainActivity.this,"Please enter email in proper formate",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edunm.getText().toString().equals("admin@gmail.com") && edpass.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
