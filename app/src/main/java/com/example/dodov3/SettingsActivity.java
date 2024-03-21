package com.example.dodov3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //TextView notificationsTextView = findViewById(R.id.notificationsTextView);
        //notificationsTextView.setOnClickListener(v -> startActivity(new Intent(SettingsActivity.this, NotificationActivity.class)));

        //TextView shareDataTextView = findViewById(R.id.shareDataTextView);
        //shareDataTextView.setOnClickListener(v -> startActivity(new Intent(SettingsActivity.this, ShareDataActivity.class)));

        //TextView accountManagementTextView = findViewById(R.id.accountManagementTextView);
        //accountManagementTextView.setOnClickListener(v -> startActivity(new Intent(SettingsActivity.this, AccountManagementActivity.class)));

        //TextView helpTextView = findViewById(R.id.helpTextView);
        //helpTextView.setOnClickListener(v -> startActivity(new Intent(SettingsActivity.this, HelpActivity.class)));

        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(v -> {
            // Implement logout logic here (e.g., clearing user session)
            // Redirect to DashboardActivity
            //Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            //startActivity(intent);
            finishAffinity();
        });
    }
}