package com.cal.moneyfish.project;

import android.os.Bundle;
import android.view.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.widget.RelativeLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;


public class Splashscreen extends Activity {

   // PaintView pV;
   // RelativeLayout rlsplash;

    private final int SPLASH_DISPLAY_LENGHT = 1400;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splashscreen);
/*
        pV=new PaintView(this);
        rlsplash=(RelativeLayout)findViewById(R.id.rlsplash);
        pV=new PaintView(this);
        rlsplash.addView(pV);
*/


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




/*
    public class PaintView extends View {
        private static final String Text = "MoneyFish";
        private Path myArc;
        private Paint mPaintText;

        public PaintView(Context context) {
            super(context);
            //create Path object
            myArc = new Path();
            //create RectF Object
            RectF oval = new RectF(50,100,200,250);
            //add Arc in Path with start angle -180 and sweep angle 200
            myArc.addArc(oval, -180, 200);
            //create paint object
            mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
            //set style
            mPaintText.setStyle(Paint.Style.FILL_AND_STROKE);
            //set color
            mPaintText.setColor(Color.BLACK);
            //set text Size
            mPaintText.setTextSize(50f);

        }
        @Override
        protected void onDraw(Canvas canvas) {
            //Draw Text on Canvas
            canvas.drawTextOnPath(Text, myArc, 0, 20, mPaintText);
            invalidate();
        }
    }

*/
}



