package com.cal.moneyfish.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Jon on 5/16/2014.
 */
public class main extends Activity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mainscreen);
            Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
            String[] items = new String[]{"3", "5", "10"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
            dropdown.setAdapter(adapter);
        }

    public void onButtonClick(View v){
        switch(v.getId()){
            case R.id.btnStart:
                Intent i = new Intent(getApplicationContext(), gathering.class);
                startActivity(i);
                break;
        }
    }

/*
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/

}
