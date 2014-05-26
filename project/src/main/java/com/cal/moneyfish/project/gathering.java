package com.cal.moneyfish.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Jon on 5/16/2014.
 */
public class gathering extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gathering);
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
