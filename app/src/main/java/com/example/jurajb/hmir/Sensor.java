package com.example.jurajb.hmir;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

/**
 * Created by Matejko on 16-Mar-17.
 */

public abstract class Sensor {
protected LinearLayout layout;

    protected android.hardware.Sensor sensor;
    String name;

    public Sensor(android.hardware.Sensor sensor){
        this.sensor = sensor;
    }

    public abstract void update();

    public abstract void start(LinearLayout l);

    public abstract void stop();

    public String toString(){
        return sensor.getName();
    }

}
