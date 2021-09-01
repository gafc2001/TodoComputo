package com.example.todocomputo;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PrinterMenuItem extends Fragment {

    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_printer,container,false);
        button = (Button) view.findViewById(R.id.btnMorePrinter);
        button.setOnClickListener(this::onClickPrinter);
        return view;
    }
    public void onClickPrinter(View view){
        switch (view.getId()){
            case R.id.btnMorePrinter:
                Intent intent = new Intent(getActivity().getApplication(),PrinterList.class);
                startActivity(intent);
                break;
        }
    }
}
