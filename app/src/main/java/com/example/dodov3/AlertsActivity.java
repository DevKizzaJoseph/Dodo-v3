package com.example.dodov3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class AlertsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);

        Button nextButton = findViewById(R.id.btnNext);
        nextButton.setOnClickListener(v -> {
            Intent intent = new Intent(AlertsActivity.this, InsolePairingActivity.class);
            startActivity(intent);
        });

        // Dummy data for demonstration
        displayAlert("High Risk Alert", "Your right foot has been at risk for the past 6 hours. Please check feet and retest.", "10:30 AM");
        displayAlert("Moderate Risk Alert", "Your left foot shows signs of moderate risk. Consider retesting in 12 hours.", "11:00 AM");
        displayAlert("Low Risk Alert", "Minor risk detected. Ensure proper foot care.", "11:30 AM");

    }

    private void displayAlert(String alertType, String explanation, String timeReceived) {
        LinearLayout alertsLayout = findViewById(R.id.alertsLayout);

        TextView alertTypeTextView = new TextView(this);
        alertTypeTextView.setText(alertType);
        alertTypeTextView.setTextSize(18);
        alertTypeTextView.setPadding(0, 10, 0, 0);

        TextView timeTextView = new TextView(this);
        timeTextView.setText(String.format("Received at: %s", timeReceived));
        timeTextView.setTextSize(16);

        TextView explanationTextView = new TextView(this);
        explanationTextView.setText(explanation);
        explanationTextView.setTextSize(16);

        Button dismissButton = new Button(this);
        dismissButton.setText("Dismiss");
        dismissButton.setOnClickListener(v -> alertsLayout.removeView((View) v.getParent()));

        LinearLayout alertLayout = new LinearLayout(this);
        alertLayout.setOrientation(LinearLayout.VERTICAL);
        alertLayout.addView(alertTypeTextView);
        alertLayout.addView(timeTextView);
        alertLayout.addView(explanationTextView);
        alertLayout.addView(dismissButton);

        alertsLayout.addView(alertLayout);
    }
}