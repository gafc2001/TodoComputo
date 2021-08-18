package com.example.todocomputo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

//Local imports
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.senati_white);
        timer.schedule(timerTask,1,10);
    }

    int seconds = 0;
    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            seconds++;
            image.setRotation(seconds);
            if(seconds == 1000){
                timerTask.cancel();
                Intent intent = new Intent(MainActivity.this,Access.class);
                startActivity(intent);
            }
        }
    };

}