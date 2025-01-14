package com.example.networksettings;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    private TextView summaryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        summaryTextView = findViewById(R.id.summaryTextView);

        // You need to pass data from BasicsActivity and EncryptionActivity
        // For now, we'll just show a placeholder text
        summaryTextView.setText("Summary Information:\n\nBasics Info: [Details]\nEncryption Info: [Selected Items]");
    }
}
