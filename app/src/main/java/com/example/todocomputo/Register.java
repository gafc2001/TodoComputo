package com.example.todocomputo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public  void onClick(View view){
        switch (view.getId()){
            case R.id.btnReturn:
                finish();
                break;
        }
    }
}