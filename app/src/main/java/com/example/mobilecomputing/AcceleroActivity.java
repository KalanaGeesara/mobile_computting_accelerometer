package com.example.mobilecomputing;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class AcceleroActivity extends Activity implements SensorEventListener {

    private TextView axisX;
    private TextView axisY;
    private TextView axisZ;
    private SensorManager sensorManager;
    private Sensor sensor;
    private boolean flag;

    public AcceleroActivity (Context context, TextView axisX, TextView axisY, TextView axisZ) {
        this.axisX = axisX;
        this.axisY = axisY;
        this.axisZ = axisZ;

        this.sensorManager = (SensorManager) context.getSystemService(SENSOR_SERVICE); //get the sensor
        this.sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void onResume() {

        super.onResume();
    }


    public void onPause() {

        super.onPause();
    }

    public void register() {

        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        flag = true;

    }

    public void unRegister() {
        sensorManager.unregisterListener(this, sensor);
        flag = false;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        String x = String.valueOf(event.values[0]);
        String y = String.valueOf(event.values[1]);
        String z = String.valueOf(event.values[2]);
        if (flag != false) {
            axisX.setText(x);
            axisY.setText(y);
            axisZ.setText(z);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
