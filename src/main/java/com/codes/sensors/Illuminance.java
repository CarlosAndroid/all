package com.codes.sensors;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codes.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Illuminance extends AppCompatActivity implements SensorEventListener{

    private SensorManager mSensorManager;
    private LinearLayout linearLayout;
    private Sensor sensorLight;
    private static String TAG = "Sensors";
    private LineChart lineChart;
    private TextView textViewIlluminance, textViewMaxValue, textViewPercentage;
    private ArrayList<Entry> listIllumination;
    private static int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illuminance);

        textViewIlluminance = (TextView) findViewById(R.id.textViewValueIllumination);
        textViewMaxValue = (TextView) findViewById(R.id.textViewMaxValueIllumination);
        textViewPercentage = (TextView) findViewById(R.id.textViewValueBrightness);
        lineChart = (LineChart) findViewById(R.id.chartIlluminance);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        sensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);



        XAxis xl = lineChart.getXAxis();

        xl.setTextColor(Color.WHITE);
        xl.setDrawGridLines(false);
        xl.setAvoidFirstLastClipping(true);
        xl.setAxisMaxValue(100f);
        xl.setAxisMinValue(0f);
        xl.setEnabled(true);

        YAxis leftAxis = lineChart.getAxisLeft();

        leftAxis.setTextColor(Color.WHITE);
        leftAxis.setAxisMaxValue(100f);
        leftAxis.setAxisMinValue(0f);
        leftAxis.setDrawGridLines(true);

        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);

        listIllumination = new ArrayList<>();

        listIllumination.add(new Entry(cont,0));
        LineDataSet lineDataSet = new LineDataSet(listIllumination, "iluminación");
        lineChart.setDescription("Porcentaje de iluminación");
        lineChart.setData(new LineData(lineDataSet));




    }

    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        mSensorManager.registerListener(this, sensorLight, SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        updateIlluminanceData(event);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void updateIlluminanceData(SensorEvent event){
        cont++;
        float illuminance = event.values[0];
        int screenBrightness = Math.round(illuminance*100/sensorLight.getMaximumRange());

        textViewIlluminance.setText("" +illuminance);
        textViewMaxValue.setText("" +sensorLight.getMaximumRange());
        textViewPercentage.setText("" +screenBrightness +"%");

        Log.d(TAG, "illuminance: " +illuminance + " - ScreenBrightness: " +screenBrightness);

        android.provider.Settings.System.putInt(getContentResolver(),
                android.provider.Settings.System.SCREEN_BRIGHTNESS,
                screenBrightness);

        addEntry(screenBrightness);

    }

    private void addEntry(int screenBrightness) {
        LineData data = lineChart.getData();
        ILineDataSet set = null;



        if(data != null) {
            set = data.getDataSetByIndex(0);
            //lineChart.setScaleMinima((float) 3f / cont, 1f);
            lineChart.moveViewTo(cont-10, 7, YAxis.AxisDependency.LEFT);
        }

        if(set == null){
            set = createSet();
            data.addDataSet(set);
        }

        listIllumination.add(new Entry(cont,screenBrightness));
        data.notifyDataChanged();
        lineChart.notifyDataSetChanged();

        //lineChart.invalidate();
        lineChart.setVisibleXRangeMaximum(50);

        //mChart.setVisibleYRangeMaximum(15, AxisDependency.LEFT);

    }

    private LineDataSet createSet() {

        LineDataSet set = new LineDataSet(null, "Dynamic Data");
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setColor(ColorTemplate.getHoloBlue());
        set.setCircleColor(Color.WHITE);
        set.setLineWidth(2f);
        set.setCircleRadius(4f);
        set.setFillAlpha(65);
        set.setFillColor(ColorTemplate.getHoloBlue());
        set.setHighLightColor(Color.rgb(244, 117, 117));
        set.setValueTextColor(Color.WHITE);
        set.setValueTextSize(9f);
        set.setDrawValues(false);
        return set;

    }
}
