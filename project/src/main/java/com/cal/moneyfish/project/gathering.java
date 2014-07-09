package com.cal.moneyfish.project;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Jon on 5/16/2014.
 */
public class Gathering extends Activity {


    private boolean mBound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Parse.initialize(this, "HA8hBtbS72Ss8BaVVVl3I8aYyapKaMpHkiit6KWG", "vyezwecy91RFjJDk6BGBdnrqgrCEygbQ5Bcx73vV");
        setContentView(R.layout.gathering);
        //ParseObject testObject = new ParseObject("TestObject");
       // testObject.put("foo", "bar");
       // testObject.saveInBackground();
    }


    public void onButtonClick(View v){
        switch(v.getId()){
            case R.id.btnStopData:
                doUnbindService();
                stopService(new Intent(Gathering.this, GPS.class));
                Intent i = new Intent(getApplicationContext(), Main.class);
                startActivity(i);
                break;
        }
    }

    void doUnbindService()
    {
        if (Main.mIsBound)
        {
            unbindService(mConnection);
            Main.mIsBound = false;
            Toast.makeText(this, "Unbinding Service", Toast.LENGTH_SHORT).show();
        }
    }



//TODO
    private ServiceConnection mConnection = new ServiceConnection()
    {
        public void onServiceConnected(ComponentName className, IBinder binder)
        {
            Toast.makeText(Gathering.this, "Connected to the service", Toast.LENGTH_SHORT)
                    .show();
        }

        public void onServiceDisconnected(ComponentName className)
        {
            Toast.makeText(Gathering.this, "Disconnected from the service", Toast.LENGTH_SHORT)
                    .show();
        }
    };

//TODO
//need to make a service that will run when the app is not active
//but is still running in the background, if the app is closed
//then the service stops running.

    //service will get the gpsPoint and push it to the DB
    //longitude and latitude.

}
