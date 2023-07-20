package com.example.e_commerce_app;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    // Duration of the splash screen in milliseconds
    private static final long SPLASH_DURATION = 4450;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        textView = findViewById(R.id.textView);

        // Create an ObjectAnimator to animate the text
        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "alpha", 0f, 1f);
        animator.setDuration(2500); // Set the duration of the animation in milliseconds
        animator.setRepeatCount(ObjectAnimator.INFINITE); // Set the repeat count of the animation (infinite in this case)
        animator.setRepeatMode(ObjectAnimator.REVERSE); // Set the repeat mode of the animation (reversing in this case)
        animator.start(); // Start the animation

        // Delayed execution to show the splash screen for the specified duration
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish(); // Optional: Close the splash activity
            }
        }, SPLASH_DURATION);
    }
}
