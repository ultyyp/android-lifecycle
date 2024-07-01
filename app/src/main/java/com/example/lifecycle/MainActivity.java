package com.example.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView lifecycleTextView;
    private StringBuilder lifecycleEvents;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lifecycleTextView = findViewById(R.id.lifecycleTextView);
        lifecycleEvents = new StringBuilder();

        logAndDisplay("onCreate");

        findViewById(R.id.buttonOpenSecond).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        logAndDisplay("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logAndDisplay("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logAndDisplay("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logAndDisplay("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndDisplay("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logAndDisplay("onDestroy");
    }

    private void logAndDisplay(String event) {
        Log.d(TAG, event);
        lifecycleEvents.append(event).append("\n");
        lifecycleTextView.setText(lifecycleEvents.toString());
    }
}