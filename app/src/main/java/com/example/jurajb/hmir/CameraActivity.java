package com.example.jurajb.hmir;

import android.hardware.Camera;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CameraActivity extends AppCompatActivity {
    private Camera mCamera = null;
    private CameraView mCameraView = null;
    private ArrayList<Sensor> sensors = new ArrayList<Sensor>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Toast.makeText(getApplicationContext(),"HOVNO",Toast.LENGTH_SHORT).show();
        try{
            mCamera = Camera.open(0);//you can use open(int) to use different cameras
        } catch (Exception e){
            Log.d("ERROR", "Failed to get camera: " + e.getMessage());
        }

        if(mCamera != null) {
            mCameraView = new CameraView(this, mCamera);//create a SurfaceView to show camera data
            FrameLayout camera_view = (FrameLayout)findViewById(R.id.camera_view);
            camera_view.addView(mCameraView);//add the SurfaceView to the layout
        }

        SensorManager mSensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        /*
        * TUNA PRIDAT VSETKY senzory CO TREBA
        * */
        sensors.add(new Compas(getApplicationContext(),mSensorManager.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER)));
        sensors.add(new Compas(getApplicationContext(),mSensorManager.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER)));
        sensors.add(new Compas(getApplicationContext(),mSensorManager.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER)));
        sensors.add(new Compas(getApplicationContext(),mSensorManager.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER)));

        //set spinner adapter
        Spinner s =(Spinner)findViewById(R.id.spinner);
        s.setAdapter(new ArrayAdapter<Sensor>(this,android.R.layout.simple_list_item_1,sensors));

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            private Sensor currentSensor = null;
            private SensorManager manager = (SensorManager) getSystemService(SENSOR_SERVICE);
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(currentSensor != null)
                    currentSensor.stop(manager);
                currentSensor = (Sensor)parentView.getSelectedItem();
                currentSensor.start(manager,(LinearLayout)findViewById(R.id.rrr));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }
}
