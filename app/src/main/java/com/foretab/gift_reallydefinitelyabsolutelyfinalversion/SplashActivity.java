package com.foretab.gift_reallydefinitelyabsolutelyfinalversion;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.animation.AnimationUtils.loadAnimation;

public class SplashActivity extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
//splash页暂时隐藏actionbar与状态栏
        iv = (ImageView) findViewById(R.id.iv) ;
        tv =(TextView)findViewById(R.id.tv);
        TextView tv = (TextView)findViewById(R.id.tv);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/hanyi.ttf");
        tv.setTypeface(typeface );
        Animation myanim = loadAnimation(this, R.anim.mytransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}
