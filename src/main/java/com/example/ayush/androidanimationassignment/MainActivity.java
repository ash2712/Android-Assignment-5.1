package com.example.ayush.androidanimationassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv1 = (TextView) findViewById(R.id.tv_fadeInAnimation);
        Button bt1 = (Button) findViewById(R.id.bt_startAnimation);
        final Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        final Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);//Declaration
        animFadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                tv1.startAnimation(animFadeOut);//starts fadeOut as soon as fadeIn gets over

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animFadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tv1.startAnimation(animFadeIn);//starts fadeIn as soon as fadeOut gets over, creating an endless loop
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setVisibility(View.VISIBLE);//makes the textview visible

                tv1.startAnimation(animFadeIn);//starts the entire loop with a fadeIn
            }
        });
    }
}
