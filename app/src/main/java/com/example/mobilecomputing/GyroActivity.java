package com.example.mobilecomputing;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

public class GyroActivity extends Activity implements SensorEventListener {

    private TextView axisX;
    private TextView axisY;
    private TextView axisZ;
    private SensorManager sensorManager;
    private Sensor sensor;
    private boolean flag;

    public GyroActivity(Context context, TextView axisX, TextView axisY, TextView axisZ) {
        this.axisX = axisX;
        this.axisY = axisY;
        this.axisZ = axisZ;

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

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

//        String sensorName = event.sensor.getName();
        String x = String.valueOf(event.values[0]);
        String y = String.valueOf(event.values[1]);
        String z = String.valueOf(event.values[2]);
        if (flag) {
            axisX.setText(x);
            axisY.setText(y);
            axisZ.setText(z);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
