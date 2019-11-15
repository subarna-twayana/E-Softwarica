package com.example.e_softwarica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user, pass;
    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=findViewById(R.id.username);
        pass=findViewById(R.id.password);
        log=findViewById(R.id.login);

        log.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (user.getText().toString().equals("Subarna") && pass.getText().toString().equals("admin")){
            Toast.makeText(this, "The username and password is correct", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,DashboardActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "The username/password is not correct", Toast.LENGTH_SHORT).show();
        }
    }
}
