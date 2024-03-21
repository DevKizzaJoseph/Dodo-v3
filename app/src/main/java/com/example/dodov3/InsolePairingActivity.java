package com.example.dodov3;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class InsolePairingActivity extends AppCompatActivity {

    private Button startPairingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insole_pairing);

        startPairingButton = findViewById(R.id.startPairingButton);

        startPairingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the phone's Bluetooth settings
                Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(intent);
            }
        });

        Button nextButton = findViewById(R.id.btnNext);
        nextButton.setOnClickListener(v -> {
            Intent intent = new Intent(InsolePairingActivity.this, SettingsActivity.class);
            startActivity(intent);
        });


    }
}