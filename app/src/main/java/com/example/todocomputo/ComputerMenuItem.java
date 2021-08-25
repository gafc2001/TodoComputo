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
import com.example.todocomputo.ComputerList;

public class ComputerMenuItem extends Fragment {

    ImageView  image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_computer,container,false);

        image=(ImageView) root.findViewById(R.id.imageComputer);
        image.setOnClickListener(this::onClickKeyboard);
        return  root;
    }
    public void onClickKeyboard(View view){
        switch (view.getId()){
            case R.id.imageComputer:
                Intent intent = new Intent(getActivity().getApplication(),ComputerList.class);
                startActivity(intent);
                break;
        }
    }

}
