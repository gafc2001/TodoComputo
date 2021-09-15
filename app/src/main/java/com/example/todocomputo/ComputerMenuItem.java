package com.example.todocomputo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ComputerMenuItem extends Fragment {

    Button btn,btnGoInsert;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_computer,container,false);

        btn=(Button) root.findViewById(R.id.btnMoreComputer);
        btn.setOnClickListener(this::onClickComputer);

        btnGoInsert = (Button) root.findViewById(R.id.btnGoInsert);
        btnGoInsert.setOnClickListener(this::onClickComputer);
        return  root;
    }
    public void onClickComputer(View view){
        switch (view.getId()){
            case R.id.btnMoreComputer:
                Intent intent = new Intent(getActivity().getApplication(),ProductList.class);
                intent.putExtra("category","Computer");
                startActivity(intent);
                break;
            case R.id.btnGoInsert:
                Intent intent2 = new Intent(getActivity().getApplication(),InsertProduct.class);

                startActivity(intent2);
                break;
        }
    }

}
