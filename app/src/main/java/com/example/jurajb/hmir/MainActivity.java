package com.example.jurajb.hmir;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        Button startButton = (Button) findViewById(R.id.startButton);

        CameraActivity camera;
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), CameraActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
