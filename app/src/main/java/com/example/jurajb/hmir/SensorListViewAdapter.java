package com.example.jurajb.hmir;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matejko on 02-Mar-17.
 */

public class SensorListViewAdapter extends ArrayAdapter<Sensor> {

    private List<Sensor> dataSet;
    private Context mContext;

    public SensorListViewAdapter(List<Sensor> data, Context context) {
        super(context, R.layout.sensor_list_view_item, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.sensor_list_view_item, null);
        }

        Sensor p = getItem(position);

        if (p != null) {
            TextView senzorNameTextView = (TextView) v.findViewById(R.id.senzorNameTextView);
            CheckBox sensorCheckBox = (CheckBox) v.findViewById(R.id.senzorCheckBox);

            if (senzorNameTextView != null) {
                senzorNameTextView.setText(p.getName());
                senzorNameTextView.setTextColor(Color.BLACK);

            }

            if (sensorCheckBox != null) {
                sensorCheckBox.setChecked(false);
                sensorCheckBox.setTextColor(Color.BLACK);
            }
        }

        return v;
    }
    /*public String getSensorName(){
        return
    }*/
}
