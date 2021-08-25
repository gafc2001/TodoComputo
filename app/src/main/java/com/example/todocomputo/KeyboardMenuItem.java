package com.example.todocomputo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.todocomputo.R;

public class KeyboardMenuItem extends Fragment {

    ImageView imageKeyboard;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_keyboard,container,false);
        imageKeyboard = (ImageView) view.findViewById(R.id.imageKeyboard);
        imageKeyboard.setOnClickListener(this::onclickKeyboard);
        return view;
    }
    public void onclickKeyboard(View view){
        switch (view.getId()){
            case R.id.imageKeyboard:
                Intent intent = new Intent(getActivity().getApplication(),KeyboardList.class);
                startActivity(intent);
                break;
        }
    }
}
