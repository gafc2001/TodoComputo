package com.example.todocomputo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.todocomputo.bdModel.ConnectionProduct;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class InsertProduct extends AppCompatActivity {

    ImageView image;
    EditText txtProduct,txtPrice,txtQuantity;
    Spinner selectCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_product);
        image = (ImageView) findViewById(R.id.imageDataBase);
        txtProduct = (EditText) findViewById(R.id.txtProduct);
        txtPrice = (EditText) findViewById(R.id.txtPrice);
        txtQuantity = (EditText) findViewById(R.id.txtQuantity);
        selectCategory = (Spinner) findViewById(R.id.selectCategory);
    }

    public void onClickInsert(View view){
        switch (view.getId()){
            case R.id.btnSelectImage:
                showOptionDialog();
                break;
            case R.id.btnSaveProduct:
                String product = txtProduct.getText().toString();
                Double price = Double.parseDouble(txtPrice.getText().toString());
                Long quantity = Long.parseLong(txtQuantity.getText().toString());
                String category = selectCategory.getSelectedItem().toString();
                Toast.makeText(this, category, Toast.LENGTH_SHORT).show();
                saveProduct(product,price,quantity,bitmap,category);
                break;
        }
    }

    private static final int selectionCode = 1;
    private void showOptionDialog(){
        final CharSequence[] options = {"Choose image", "Cancel"};
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Choose a option");

        alert.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(options[i].equals("Choose image")){
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/");
                    startActivityForResult(intent.createChooser(intent,"Choose"),selectionCode);
                }
            }
        });
        alert.show();
    }
    Bitmap bitmap;


    public void onActivityResult(int getCode,int codeResult,Intent data){
        if(data != null){
            super.onActivityResult(getCode,codeResult,data);
            switch (getCode){
                case selectionCode:
                    Uri route = data.getData();
                    image = (ImageView) findViewById(R.id.imageDataBase);
                    image.setImageURI(route);
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),route);
                        image.setImageBitmap(bitmap);
                    }catch(IOException e) {

                    }
                    break;
            }
        }
    }
    public void saveProduct(String product,Double price, Long quantity, Bitmap bitmap,String category){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(20480);
        bitmap.compress(Bitmap.CompressFormat.PNG,0,outputStream);
        byte[] imageSize = outputStream.toByteArray();
        ConnectionProduct cn = new ConnectionProduct(this,"products",null,1);
        SQLiteDatabase db = cn.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from products",null);
        long size = cursor.getCount() + 1;

        SQLiteDatabase insert  = cn.getWritableDatabase();
        if(insert != null){
            String sql = "INSERT INTO products(id,product,price,quantity,category,image) VALUES(?,?,?,?,?,?)";
            SQLiteStatement stmt = insert.compileStatement(sql);
            stmt.clearBindings();
            stmt.bindLong(1,size);
            stmt.bindString(2,product);
            stmt.bindDouble(3,price);
            stmt.bindLong(4,quantity);
            stmt.bindString(5,category);
            stmt.bindBlob(6,imageSize);
            stmt.executeInsert();
            db.close();
            insert.close();
            Toast.makeText(this, "Save succesfully", Toast.LENGTH_LONG).show();
        }

    }
}