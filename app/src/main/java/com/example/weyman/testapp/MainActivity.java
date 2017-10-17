package com.example.weyman.testapp;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.location.LocationManager;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements LocationListener{

    int MY_PERMISSIONS_ACCESS_FINE_LOCATION = 99;
    static double  LATITUDE;
    static double LONGITUDE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                MY_PERMISSIONS_ACCESS_FINE_LOCATION);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        //final Location location = new Location(LocationManager.GPS_PROVIDER);

        final Button gpsButton = (Button) findViewById(R.id.GPSbutton);
        final EditText ed=(EditText)findViewById(R.id.editText);
        gpsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                ed.setText("lat: "+Double.toString(LATITUDE)+ "lon:"+Double.toString(LONGITUDE));
            }
        });
        final Button mapButton = (Button) findViewById(R.id.button2);
        mapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent myIntent = new Intent(MainActivity.this,
                        MapsActivity.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onLocationChanged(Location location) {
        //TODO Auto-generated method stub
        LATITUDE = location.getLatitude();
        LONGITUDE = location.getLongitude();


//        final EditText ed=(EditText)findViewById(R.id.editText);
//        ed.setText(Double.toString(latitude)+ "lon:"+Double.toString(longitude));


        //Log.i("Geo_Location", "Latitude: " + latitude + ", Longitude: " + longitude);
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

}
