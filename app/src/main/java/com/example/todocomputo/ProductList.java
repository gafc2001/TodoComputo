package com.example.todocomputo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todocomputo.bdModel.ConnectionProduct;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class ProductList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<String> array;
    TextView titleListProduct;
    ImageView productImage;
    ListView list;
    ConnectionProduct con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        titleListProduct = (TextView) findViewById(R.id.titleListProduct);

        list = (ListView) findViewById(R.id.ListItemProducts);
        list.setOnItemClickListener(this::onItemClick);
        productImage = (ImageView) findViewById(R.id.productImage);
        array = new ArrayList<String>();
        con = new ConnectionProduct(this,"products",null,1);
        SQLiteDatabase db = con.getReadableDatabase();
        String sql = String.format("SELECT * FROM products WHERE category = '%s'",getCategory());
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                String id = cursor.getString(0);
                String product = cursor.getString(1);
                String price = cursor.getString(2);
                String quantity = cursor.getString(3);

                String item = String.format("%s - %s - %s - %s",id,product,price,quantity);
                array.add(item);
            }while(cursor.moveToNext());

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array);
            list.setAdapter(arrayAdapter);
        }
        Toast.makeText(this, getCategory(), Toast.LENGTH_SHORT).show();


    }
    public String getCategory(){
        String datos = "null";
        Bundle params = this.getIntent().getExtras();
        if(params !=null){
            datos = params.getString("category");
            titleListProduct.setText(datos);
        }
        return datos;
    }
    public void onClickComputer(View view){
        switch (view.getId()) {
            case R.id.returnMenu:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String text = (String)list.getItemAtPosition(i);
        Long id = Long.parseLong(String.valueOf(text.charAt(0)));

        productImage.setImageBitmap(showImage(id));

    }

    public Bitmap showImage(Long id){
        SQLiteDatabase db = con.getReadableDatabase();
        String sql = String.format("select * from products where id = %d",id);
        Cursor cursor = db.rawQuery(sql, new String[]{});

        Bitmap bitmap = null;
        if(cursor.moveToFirst()){
            byte[] image = cursor.getBlob(5);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(image);
            bitmap = BitmapFactory.decodeStream(inputStream);
        }
        if(cursor != null && !cursor.isClosed()){
            cursor.close();
        }
        db.close();
        return bitmap;
    }
}
