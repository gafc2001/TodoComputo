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
import com.example.todocomputo.ComputerList;

public class ComputerMenuItem extends Fragment {

    Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_computer,container,false);

        btn=(Button) root.findViewById(R.id.btnMoreComputer);
        btn.setOnClickListener(this::onClickKeyboard);
        return  root;
    }
    public void onClickKeyboard(View view){
        switch (view.getId()){
            case R.id.btnMoreComputer:
                Intent intent = new Intent(getActivity().getApplication(),ComputerList.class);
                startActivity(intent);
                break;
        }
    }

}
