package com.example.vetcare;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.vetcare.R.id.opening_title;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 1500;

    Animation centeranime;
    TextView nameofApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        centeranime = AnimationUtils.loadAnimation(this, R.anim.center_animation);

        nameofApp = findViewById(opening_title);

        nameofApp.setAnimation(centeranime);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}