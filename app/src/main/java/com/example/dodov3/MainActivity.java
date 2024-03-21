package com.example.dodov3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView pressureTextView, temperatureTextView, humidityTextView;
    private ProgressBar pressureProgressBar, temperatureProgressBar, humidityProgressBar;
    private TextView footHealthStatusTextView, pressureStatusTextView, temperatureStatusTextView, humidityStatusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextButton = findViewById(R.id.btnNext);
        nextButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AlertsActivity.class);
            startActivity(intent);
        });

        // Initialize UI components
        pressureTextView = findViewById(R.id.pressureTextView);
        temperatureTextView = findViewById(R.id.temperatureTextView);
        humidityTextView = findViewById(R.id.humidityTextView);

        pressureProgressBar = findViewById(R.id.pressureProgressBar);
        temperatureProgressBar = findViewById(R.id.temperatureProgressBar);
        humidityProgressBar = findViewById(R.id.humidityProgressBar);

        footHealthStatusTextView = findViewById(R.id.footHealthStatusTextView);
        pressureStatusTextView = findViewById(R.id.pressureStatusTextView);
        temperatureStatusTextView = findViewById(R.id.temperatureStatusTextView);
        humidityStatusTextView = findViewById(R.id.humidityStatusTextView);

        // Simulate receiving new readings
        updateUI(new Reading(70, 25, 45, "Good", "High", "Normal", "Normal"));
    }

    private void updateUI(Reading reading) {
        // Update text views and progress bars based on the reading
        pressureTextView.setText(String.format(Locale.getDefault(), "Pressure: %d%%", reading.getPressure()));
        temperatureTextView.setText(String.format(Locale.getDefault(), "Temperature: %d°C", reading.getTemperature()));
        humidityTextView.setText(String.format(Locale.getDefault(), "Humidity: %d%%", reading.getHumidity()));

        pressureStatusTextView.setText(String.format("Status: %s", reading.getPressureStatus()));
        temperatureStatusTextView.setText(String.format("Status: %s", reading.getTemperatureStatus()));
        humidityStatusTextView.setText(String.format("Status: %s", reading.getHumidityStatus()));

        // Set progress bars
        pressureProgressBar.setProgress(reading.getPressure());
        temperatureProgressBar.setProgress(reading.getTemperature());
        humidityProgressBar.setProgress(reading.getHumidity());

        // Set progress bar colors based on the status
        pressureProgressBar.getProgressDrawable().setColorFilter(getColorForStatus(reading.getPressureStatus()), android.graphics.PorterDuff.Mode.SRC_IN);
        temperatureProgressBar.getProgressDrawable().setColorFilter(getColorForStatus(reading.getTemperatureStatus()), android.graphics.PorterDuff.Mode.SRC_IN);
        humidityProgressBar.getProgressDrawable().setColorFilter(getColorForStatus(reading.getHumidityStatus()), android.graphics.PorterDuff.Mode.SRC_IN);
    }

    private int getColorForStatus(String status) {
        switch (status) {
            case "Good":
                return Color.GREEN;
            case "Normal":
                return Color.YELLOW;
            case "High":
                return Color.RED;
            default:
                return Color.GRAY;
        }
    }

    // Inner class to represent a reading. In a real application, this could be a model class fetched from a service or device.
    private static class Reading {
        private int pressure;
        private int temperature;
        private int humidity;
        private String footHealthStatus;
        private String pressureStatus;
        private String temperatureStatus;
        private String humidityStatus;

        public Reading(int pressure, int temperature, int humidity, String footHealthStatus, String pressureStatus, String temperatureStatus, String humidityStatus) {
            this.pressure = pressure;
            this.temperature = temperature;
            this.humidity = humidity;
            this.footHealthStatus = footHealthStatus;
            this.pressureStatus = pressureStatus;
            this.temperatureStatus = temperatureStatus;
            this.humidityStatus = humidityStatus;
        }

        public int getPressure() {
            return pressure;
        }

        public int getTemperature() {
            return temperature;
        }

        public int getHumidity() {
            return humidity;
        }

        public String getFootHealthStatus() {
            return footHealthStatus;
        }

        public String getPressureStatus() {
            return pressureStatus;
        }

        public String getTemperatureStatus() {
            return temperatureStatus;
        }

        public String getHumidityStatus() {
            return humidityStatus;
        }
    }
}