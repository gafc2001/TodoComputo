package com.example.todocomputo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todocomputo.bdModel.Connection;

public class Access extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    Connection cn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);
        txtUsername = (EditText) findViewById(R.id.txtUserLogin);
        txtPassword = (EditText) findViewById(R.id.txtPasswordLogin);
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
            case R.id.btnLogin:
                String sql = "SELECT * FROM user WHERE username = '%s' and password = '%s'";
                String formattedSql = String.format(sql,txtUsername.getText(),txtPassword.getText());

                cn = new Connection(this,"todocomputodb",null,1);
                SQLiteDatabase bd = cn.getWritableDatabase();

                Cursor cursor = bd.rawQuery(formattedSql,null);
                if(cursor.getCount() == 1){
                    Intent intent2 = new Intent(Access.this,MainPanel.class);
                    startActivity(intent2);
                    Toast.makeText(this,"Welcome " + txtUsername.getText() ,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"User or password is incorrect",Toast.LENGTH_LONG).show();
                }


                break;
        }


    }
}