package com.example.todocomputo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.todocomputo.bdModel.Connection;
import com.example.todocomputo.bdModel.User;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText txtName,txtUserName,txtPassword,txtEmail;

    User user;
    Connection cn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtName = (EditText) findViewById(R.id.txtNamesRegister);
        txtUserName = (EditText) findViewById(R.id.txtUserRegister);
        txtPassword = (EditText) findViewById(R.id.txtPasswordRegister);
        txtEmail = (EditText) findViewById(R.id.txtEmailRegister);

    }
    public  void onClickRegister(View view){
        switch (view.getId()){
            case R.id.btnReturn:
                finish();
                break;
            case R.id.btnRegister:
                cn = new Connection(this,"todocomputodb",null,1);
                user = new User();
                SQLiteDatabase bd = cn.getWritableDatabase();
                if(bd != null){
                    String sql = "INSERT INTO user(username,fullname,password,email) VALUES('%s','%s','%s','%s')";
                    String formattedSql = String.format(sql,
                                                txtUserName.getText(),
                                                txtName.getText(),
                                                txtPassword.getText(),
                                                txtEmail.getText());
                    bd.execSQL(formattedSql);
                    Toast.makeText(this,"201 Created",Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}