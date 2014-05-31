package com.cal.moneyfish.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;

/**
 * Created by Jon on 5/16/2014.
 */
public class gathering extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "HA8hBtbS72Ss8BaVVVl3I8aYyapKaMpHkiit6KWG", "vyezwecy91RFjJDk6BGBdnrqgrCEygbQ5Bcx73vV");
        setContentView(R.layout.gathering);
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }


    public void onButtonClick(View v){
        switch(v.getId()){
            case R.id.btnStopData:
                Intent i = new Intent(getApplicationContext(), main.class);
                startActivity(i);
                break;
        }
    }



}
