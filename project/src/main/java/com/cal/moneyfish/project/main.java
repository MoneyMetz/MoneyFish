package com.cal.moneyfish.project;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Jon on 5/16/2014.
 */
public class Main extends Activity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mainscreen);
            Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
            String[] items = new String[]{"3", "5", "10"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
            dropdown.setAdapter(adapter);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent in = new Intent(getApplicationContext(),Instructions.class);
            startActivity(in);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private ServiceConnection mConnection = new ServiceConnection()
    {
        public void onServiceConnected(ComponentName className, IBinder binder)
        {
            Toast.makeText(Main.this, "Connected to the service", Toast.LENGTH_SHORT)
                    .show();
        }

        public void onServiceDisconnected(ComponentName className)
        {
            Toast.makeText(Main.this, "Disconnected from the service", Toast.LENGTH_SHORT)
                    .show();
        }
    };



    private boolean mIsBound = false;

    public void onButtonClick(View v)
    {
        switch (v.getId())
        {


            case R.id.btnStart:
                //bind allows the passing of info
                doBindService();
                //starting service
                startService(new Intent(Main.this, GPS.class));
                //start next activity
                Intent i = new Intent(getApplicationContext(), Gathering.class);
                startActivity(i);
                break;

            default:
        }
    }



    void doBindService()
    {
        mIsBound = true;
        bindService(new Intent(this, GPS.class), mConnection, Context.BIND_AUTO_CREATE);
    }


}
