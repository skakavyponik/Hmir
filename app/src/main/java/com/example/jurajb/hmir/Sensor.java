package com.example.jurajb.hmir;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.LinearLayout;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by Matejko on 16-Mar-17.
 */

public abstract class Sensor implements SensorEventListener {
    protected LinearLayout layout;
    protected SensorManager manager;

    protected android.hardware.Sensor sensor;

    public Sensor(android.hardware.Sensor sensor,SensorManager manager){
        this.sensor = sensor;
        this.manager = manager;
    }

    public abstract void update(SensorEvent event);

    public abstract void getView(LinearLayout l);

    public void start(LinearLayout l){
        getView(l);
        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }


    public void stop(SensorManager manager){
        manager.unregisterListener(this);
    }

    public String toString(){
        return sensor.getName();
    }

    //@Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == sensor.getType()) {
            update(event);
        }
    }
}
