package com.example.todocomputo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ComputerList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_list);
    }
    public void onClickComputer(View view){
        switch (view.getId()) {
            case R.id.returnMenuComputer:
                finish();
                break;
        }
    }
}