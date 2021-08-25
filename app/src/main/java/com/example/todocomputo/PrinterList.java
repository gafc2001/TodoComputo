package com.example.todocomputo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class PrinterList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer_list);
    }
    public void onClickPrinter(View view){
        switch (view.getId()) {
            case R.id.returnMenuPrinter:
                finish();
                break;
        }
    }
}