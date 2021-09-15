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

import com.example.todocomputo.R;

public class KeyboardMenuItem extends Fragment {

    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_keyboard,container,false);
        button = (Button) view.findViewById(R.id.btnMoreKeyboard);
        button.setOnClickListener(this::onclickKeyboard);
        return view;
    }
    public void onclickKeyboard(View view){
        switch (view.getId()){
            case R.id.btnMoreKeyboard:
                Intent intent = new Intent(getActivity().getApplication(),ProductList.class);
                intent.putExtra("category","Keyboard");
                startActivity(intent);
                break;
        }
    }
}
