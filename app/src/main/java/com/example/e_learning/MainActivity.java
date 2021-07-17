package com.example.e_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN =2000 ;

    //----------------------------------------------------------------------Variable----------------------------------------------------------------------//
    Animation up_anim,down_anim;
    ImageView logo;
    TextView appname,tagline;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //----------------------------------------------------------------------Remove ActionBar----------------------------------------------------------------------//

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //----------------------------------------------------------------------Declaration----------------------------------------------------------------------//

        logo=findViewById(R.id.imageView);
        appname=findViewById(R.id.appName);
        tagline=findViewById(R.id.tagLine);

        //----------------------------------------------------------------------Animation----------------------------------------------------------------------//


        up_anim= AnimationUtils.loadAnimation(this,R.anim.upanim);
        down_anim=AnimationUtils.loadAnimation(this,R.anim.bottomanim);

        logo.setAnimation(up_anim);
        appname.setAnimation(down_anim);
        tagline.setAnimation(down_anim);

        //----------------------------------------------------------------------Splash Screen Delayed----------------------------------------------------------------------//

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,login.class);
               // Pair[] pairs=new Pair[2];
                //pairs[0]=new Pair<View,String>(logo,"logo_image");
                //pairs[1]=new Pair<View,String>(appname,"logo_text");


                    //ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    //startActivity(intent, options.toBundle());
                startActivity(intent);
                    finish();

            }
        },SPLASH_SCREEN);





    }
}