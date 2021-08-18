package com.example.todocomputo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Access extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);
    }
    public void goRegister(View view){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
}