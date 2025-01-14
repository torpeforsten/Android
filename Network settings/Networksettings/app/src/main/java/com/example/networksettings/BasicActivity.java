package com.example.networksettings; // Ensure this matches your package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView; // Import TextView
import android.graphics.Typeface; // Import Typeface
import androidx.appcompat.app.AppCompatActivity;

public class BasicActivity extends AppCompatActivity {

    private EditText networkNameEditText;
    private Spinner networkTypeSpinner;
    private Button submitButton;
    private TextView titleTextView; // Declare a TextView for the title

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics); // Ensure this matches your XML layout file

        // Initialize the views
        networkNameEditText = findViewById(R.id.networkNameEditText);
        networkTypeSpinner = findViewById(R.id.networkTypeSpinner);
        submitButton = findViewById(R.id.submitButton);

        // Cast the TextView
        titleTextView = findViewById(R.id.titleTextView); // Assuming there's a TextView with this ID

        // Set text color and typeface on the TextView (if it exists)
        titleTextView.setTextColor(getResources().getColor(R.color.colorPrimary)); // Replace with your defined color
        titleTextView.setTypeface(null, Typeface.BOLD); // Set bold typeface

        // Set up the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.network_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        networkTypeSpinner.setAdapter(adapter);

        // Set up the submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input data
                String networkName = networkNameEditText.getText().toString();
                String networkType = networkTypeSpinner.getSelectedItem().toString();

                // Create an intent to return the data to the main activity
                Intent intent = new Intent();
                intent.putExtra("NETWORK_NAME", networkName);
                intent.putExtra("NETWORK_TYPE", networkType);
                setResult(RESULT_OK, intent);
                finish(); // Close this activity and return to the previous one
            }
        });
    }
}
