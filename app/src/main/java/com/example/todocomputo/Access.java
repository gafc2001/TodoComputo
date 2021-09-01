package com.example.todocomputo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Access extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);
    }
    public void onClickLogin(View view){
        switch (view.getId()){
            case R.id.lblCreateAccount:
                Intent intent = new Intent(this,Register.class);
                startActivity(intent);
                break;
            case R.id.btnCloseAll:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setMessage("Do you wanna close the app?");
                dialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                });
                dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                dialog.show();
                break;
            case R.id.btnRegister:
                Intent intent2 = new Intent(Access.this,MainPanel.class);
                startActivity(intent2);
                break;
        }


    }
}