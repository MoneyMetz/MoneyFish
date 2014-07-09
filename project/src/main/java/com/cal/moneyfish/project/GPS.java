package com.cal.moneyfish.project;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by jjmetzler on 6/14/14.
 */
public class GPS extends Service  {

    // An interface object used by clients to communicate with the service.
    private final IBinder mBinder = new MyBinder();
    LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
    boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);


    @Override
    public void onCreate()
    {
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {





        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        return Service.START_STICKY;	// Service will be explicitly started and stopped as needed.
    }

    @Override
    public IBinder onBind(Intent i)
    {
        Toast.makeText(this, "Binding Service", Toast.LENGTH_SHORT).show();
        return mBinder;
    }

    public class MyBinder extends Binder
    {



    }

/*
    private final LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            longitude = location.getLongitude();
            latitude = location.getLatitude();
        }
    }

    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
*/

    public void onDestroy()
    {
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
    }






}
