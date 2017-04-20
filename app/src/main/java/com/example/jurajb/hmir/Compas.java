package com.example.jurajb.hmir;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by Matejko on 16-Mar-17.
 */

public class Compas extends Sensor {
    Compas(android.hardware.Sensor sensor,SensorManager manager){
        super(sensor,manager);
    }

    public void update(SensorEvent event){

    }

    public void getView(LinearLayout l){
       // Toast.makeText(context,"start" ,Toast.LENGTH_SHORT).show();
    }
}
