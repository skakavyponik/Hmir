package com.example.jurajb.hmir;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Matejko on 16-Mar-17.
 */

public class Compas extends Sensor {
    Context context;
    Compas(Context context,android.hardware.Sensor sensor){
        super(sensor);
        this.context = context;
    }

    public void update(){

    }

    public void start(LinearLayout l){
        Toast.makeText(context,"start" ,Toast.LENGTH_SHORT).show();
    }

    public void stop(){
        Toast.makeText(context,"stop" ,Toast.LENGTH_SHORT).show();
    }

}