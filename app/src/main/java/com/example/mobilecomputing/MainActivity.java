package com.example.mobilecomputing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button startBtn;
    private TextView axisX;
    private TextView axisY;
    private TextView axisZ;
    private AcceleroActivity accleroActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startActivity(View view) {

        if (startBtn == null) startBtn = (Button) findViewById(R.id.startBtn);
        if (axisX == null) axisX = (TextView) findViewById(R.id.xAxisTextView);
        if (axisY == null) axisY = (TextView) findViewById(R.id.yAxisTextView);
        if (axisZ ==null) axisZ = (TextView) findViewById(R.id.zAxisTextView);

        if (accleroActivity == null) accleroActivity = new AcceleroActivity(this, axisX, axisY, axisZ);
        if (startBtn.getText().equals("Start")) {
            startBtn.setText("Stop");
            startBtn.setBackgroundColor(Color.RED);
            accleroActivity.register();
        } else {
            startBtn.setText("Start");
            startBtn.setBackgroundColor(Color.GREEN);
            accleroActivity.unRegister();

        }


    }
}
