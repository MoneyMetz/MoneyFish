package com.cal.moneyfish.project;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;



public class Splashscreen extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 1400;





    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splashscreen);


        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splashscreen.this,Main.class);
                Splashscreen.this.startActivity(mainIntent);


                Splashscreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }


}



