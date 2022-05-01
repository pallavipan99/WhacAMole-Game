package com.example.whacaduck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    ImageView duck;
    ImageView duck2;
    ImageView duck3;
    ImageView duck4;
    ImageView duck5;
    ImageView duck6;
    ImageView duck7;
    ImageView duck8;
    ImageView duck9;
    TextView timer;
    TextView num;
    ConstraintLayout constraintLayout;
    ConstraintLayout constraintLayout2;
    int score = 0;
    int randomNum = (int) (Math.random() * 3);
    int randNum2 = (int) (Math.random() * 9);
    private int second = 60;
    Integer resource=0;
    Integer resource2=0;
    Integer resource3=0;
    Integer resource4=0;
    Integer resource5=0;
    Integer resource6=0;
    Integer resource7=0;
    Integer resource8=0;
    Integer resource9=0;
    Integer resource10=0;
    Integer resource11=0;
    Integer resource12=0;
    Integer resource13=0;
    Integer resource14=0;
    Integer resource15=0;
    Integer resource16=0;
    Integer resource17=0;
    Integer resource18=0;
    int count = 0;
    int count2= 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    int count6 = 0;
    int count7 = 0;
    int count8 = 0;
    int count9 = 0;
    int count10 = 0;
    int count11= 0;
    int count12 = 0;
    int count13 = 0;
    int count14 = 0;
    int count15 = 0;
    int count16 = 0;
    int count17 = 0;
    int count18 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = findViewById(R.id.timer);
        num = findViewById(R.id.numOfMoles);
        constraintLayout = findViewById(R.id.layout);
        constraintLayout2 = findViewById(R.id.layout);


        duck = findViewById(R.id.imageView);
        duck2 = findViewById(R.id.imageView2);
        duck3 = findViewById(R.id.imageView3);
        duck4 = findViewById(R.id.imageView4);
        duck5 = findViewById(R.id.imageView5);
        duck6 = findViewById(R.id.imageView6);
        duck7 = findViewById(R.id.imageView7);
        duck8 = findViewById(R.id.imageView8);
        duck9 = findViewById(R.id.imageView9);

        duck.setImageResource(R.drawable.duck);
        duck2.setImageResource(R.drawable.duck);
        duck3.setImageResource(R.drawable.duck);
        duck4.setImageResource(R.drawable.duck);
        duck5.setImageResource(R.drawable.duck);
        duck6.setImageResource(R.drawable.duck);
        duck7.setImageResource(R.drawable.duck);
        duck8.setImageResource(R.drawable.duck);
        duck9.setImageResource(R.drawable.duck);

        duck.setTag(R.drawable.bonusduck);
        duck2.setTag(R.drawable.bonusduck);
        duck3.setTag(R.drawable.bonusduck);
        duck4.setTag(R.drawable.bonusduck);
        duck5.setTag(R.drawable.bonusduck);
        duck6.setTag(R.drawable.bonusduck);
        duck7.setTag(R.drawable.bonusduck);
        duck8.setTag(R.drawable.bonusduck);
        duck9.setTag(R.drawable.bonusduck);


        ImageView clickCount = new ImageView(this);

        clickCount.setId(View.generateViewId());
        clickCount.setImageResource(R.drawable.countduck);

        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

        clickCount.setLayoutParams(params);
        constraintLayout.addView(clickCount);

        ConstraintSet images = new ConstraintSet();
        images.connect(clickCount.getId(), ConstraintSet.TOP, constraintLayout.getId(), ConstraintSet.TOP);
        images.connect(clickCount.getId(), ConstraintSet.BOTTOM, constraintLayout.getId(), ConstraintSet.BOTTOM);
        images.connect(clickCount.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT);
        images.connect(clickCount.getId(), ConstraintSet.RIGHT, constraintLayout.getId(), ConstraintSet.RIGHT);

        images.setHorizontalBias(clickCount.getId(), 0f);
        images.setVerticalBias(clickCount.getId(), 0f);

        images.applyTo(constraintLayout);
        images.clone(constraintLayout);


/*

        ImageView click = new ImageView(this);
        click.setId(View.generateViewId());
        click.setImageResource(R.drawable.countduck);

        ConstraintLayout.LayoutParams param = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

        click.setLayoutParams(param);
        constraintLayout2.addView(click);

        ConstraintSet images2 = new ConstraintSet();
        images2.clone(constraintLayout2);
        images2.connect(clickCount.getId(), ConstraintSet.TOP, constraintLayout2.getId(), ConstraintSet.TOP);
        images2.connect(clickCount.getId(), ConstraintSet.BOTTOM, constraintLayout2.getId(), ConstraintSet.BOTTOM);
        images2.connect(clickCount.getId(), ConstraintSet.LEFT, constraintLayout2.getId(), ConstraintSet.LEFT);
        images2.connect(clickCount.getId(), ConstraintSet.RIGHT, constraintLayout2.getId(), ConstraintSet.RIGHT);

        images2.setHorizontalBias(clickCount.getId(), .445f);
        images2.setVerticalBias(clickCount.getId(), 0f);

        images2.applyTo(constraintLayout2);

         */


        duck.setVisibility(View.INVISIBLE);
        duck2.setVisibility(View.INVISIBLE);
        duck3.setVisibility(View.INVISIBLE);
        duck4.setVisibility(View.INVISIBLE);
        duck5.setVisibility(View.INVISIBLE);
        duck6.setVisibility(View.INVISIBLE);
        duck7.setVisibility(View.INVISIBLE);
        duck8.setVisibility(View.INVISIBLE);
        duck9.setVisibility(View.INVISIBLE);

        Animation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(8000);

        Animation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        fadeOut.setStartOffset(1000);
        fadeOut.setDuration(8000);

        AnimationSet animation = new AnimationSet(true);

        Timer timer1 = new Timer();
        TimerTask time = new TimerTask() {
            @Override
            public void run() {
                randNum2 = (int) (Math.random() * 9);
                randomNum = (int) (Math.random() * 10);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (randNum2 == 1) {
                            if (randomNum == 1) {
                                duck.setImageResource(R.drawable.bonusduck);
                                duck.setTag(R.drawable.bonusduck);
                                resource = R.drawable.bonusduck;
                            }
                            else{
                                resource = 0;
                            }
                            duck.setVisibility(View.VISIBLE);

                        }
                        if (randNum2 == 2) {
                            if (randomNum == 1) {
                                duck2.setImageResource(R.drawable.bonusduck);
                                duck2.setTag(R.drawable.bonusduck);
                                resource2 = R.drawable.bonusduck;
                            }
                            else{
                                resource2 = 0;
                            }
                            duck2.setVisibility(View.VISIBLE);
                        }
                        if (randNum2 == 3) {
                            if (randomNum == 1) {
                                duck3.setImageResource(R.drawable.bonusduck);
                                duck3.setTag(R.drawable.bonusduck);
                                resource3 = R.drawable.bonusduck;
                            }
                            else{
                                resource3 =0;

                            }
                            duck3.setVisibility(View.VISIBLE);
                        }
                        if (randNum2 == 4) {
                            if (randomNum == 1) {
                                duck4.setImageResource(R.drawable.bonusduck);
                                duck4.setTag(R.drawable.bonusduck);
                                resource4 = R.drawable.bonusduck;
                            }
                            else{
                                resource4 = 0;
                            }
                            duck4.setVisibility(View.VISIBLE);
                        }
                        if (randNum2 == 5) {
                            if (randomNum == 1) {
                                duck5.setImageResource(R.drawable.bonusduck);
                                duck5.setTag(R.drawable.bonusduck);
                                resource5 = R.drawable.bonusduck;
                            }
                            duck5.setVisibility(View.VISIBLE);
                            resource5 = 0;
                        }
                        if (randNum2 == 6) {
                            if (randomNum == 1) {
                                duck6.setImageResource(R.drawable.bonusduck);
                                duck6.setTag(R.drawable.bonusduck);
                                resource6 = R.drawable.bonusduck;
                            }
                            else{
                                resource6 = 0;
                            }
                            duck6.setVisibility(View.VISIBLE);

                        }
                        if (randNum2 == 7) {
                            if (randomNum == 1) {
                                duck7.setImageResource(R.drawable.bonusduck);
                                duck7.setTag(R.drawable.bonusduck);
                                resource7 = R.drawable.bonusduck;
                            }
                            else{
                                resource7 = 0;
                            }
                            duck7.setVisibility(View.VISIBLE);
                        }
                        if (randNum2 == 8) {
                            if (randomNum == 1) {
                                duck8.setImageResource(R.drawable.bonusduck);
                                duck8.setTag(R.drawable.bonusduck);
                                resource8 = R.drawable.bonusduck;
                            }
                            else{
                                resource8 = 0;
                            }
                            duck8.setVisibility(View.VISIBLE);

                        }
                        if (randNum2 == 9) {
                            if (randomNum == 1) {
                                duck9.setImageResource(R.drawable.bonusduck);
                                duck9.setTag(R.drawable.bonusduck);
                                resource9 = R.drawable.bonusduck;
                            }
                            else{
                                resource9 = 0;
                            }
                            duck9.setVisibility(View.VISIBLE);
                        }



    }
}