package com.example.jurajb.hmir;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView sensorListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorListView = (ListView) findViewById(R.id.SensorList);

        // Get the SensorManager
        SensorManager mSensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);

        // List of Sensors Available
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        Toast.makeText(getApplicationContext(),"size = " + sensorList.size(),Toast.LENGTH_SHORT).show();

        //create sensor sensorAdapter
        SensorListViewAdapter sensorAdapter = new SensorListViewAdapter(sensorList,getApplicationContext());

        //set all sensors to listView
        sensorListView.setAdapter(sensorAdapter);

        /*sensorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getBaseContext(),sensorListView.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
