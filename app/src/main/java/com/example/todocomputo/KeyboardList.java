package com.example.todocomputo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class KeyboardList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_list);
    }
    public void onClickKeyboard(View view){
        switch (view.getId()) {
            case R.id.returnMenuKeyboard:
                finish();
                break;
        }
    }
}