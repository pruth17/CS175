package edu.sjsu.android.accgame;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.WindowManager;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private PowerManager.WakeLock mWakeLock;
    // The view
    private SimulationView mSimulationView;
    private SensorManager sensorManager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PowerManager mPowerManager = (PowerManager) getSystemService(POWER_SERVICE);
        mWakeLock = mPowerManager.newWakeLock(
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, TAG);
        mSimulationView = new SimulationView(this);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        setContentView(mSimulationView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // acquire wakelock
        mWakeLock.acquire();
        // start simulation to register the listener
        mSimulationView.startSimulation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Release wakelock
        mWakeLock.release();
        // stop simulation to unregister the listener
        mSimulationView.stopSimulation();
    }
}
