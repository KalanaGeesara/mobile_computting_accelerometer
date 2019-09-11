package com.example.mobilecomputing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button startBtn;
    private TextView axisX;
    private TextView axisY;
    private TextView axisZ;
    private GyroActivity gyroActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startActivity() {

        startBtn = (Button) findViewById(R.id.startBtn);
        axisX = (TextView) findViewById(R.id.xAxisTextView);
        axisX = (TextView) findViewById(R.id.yAxisTextView);
        axisX = (TextView) findViewById(R.id.zAxisTextView);

        gyroActivity = new GyroActivity(this, axisX, axisY, axisZ);
        if (startBtn.getText().equals("Start")) {
            startBtn.setText("Stop");
            gyroActivity.register();
        } else {
            startBtn.setText("Start");
            gyroActivity.unRegister();
        }


    }
}
