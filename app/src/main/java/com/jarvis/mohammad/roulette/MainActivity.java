package com.jarvis.mohammad.roulette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b;
    ImageView imageView;
    Random r;
    int x,y;
    int degree=0,degree_old=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b= findViewById(R.id.button2);
        imageView=findViewById(R.id.wheel);
        r= new Random();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                degree_old=degree%360;
                degree=r.nextInt(3600)+720;
                x=imageView.getWidth()/2;
                y=imageView.getHeight()/2;
                RotateAnimation rotateAnimation= new RotateAnimation(degree_old,degree,x,y);
                rotateAnimation.setDuration(3600);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            imageView.startAnimation(rotateAnimation);
            }
        });
    }

}
