package com.example.shoppinglist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextItem;
    private Button buttonSave, buttonDone;
    private ArrayList<String> shoppingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextItem = findViewById(R.id.editTextItem);
        buttonSave = findViewById(R.id.buttonSave);
        buttonDone = findViewById(R.id.buttonDone);
        shoppingList = new ArrayList<>();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editTextItem.getText().toString().trim();
                if (isItemValid(item)) {
                    shoppingList.add(item);
                    Toast.makeText(MainActivity.this, "Item saved!", Toast.LENGTH_SHORT).show();
                    editTextItem.setText(""); // Clear input
                } else {
                    showErrorDialog("Item must be between 5 and 10 characters and cannot contain whitespace.");
                }
            }
        });

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();
            }
        });
    }

    private boolean isItemValid(String item) {
        return item.length() >= 5 && item.length() <= 10 && !item.contains(" ");
    }

    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }

    private void showOptionsDialog() {
        String[] options = {"Show items", "Send SMS", "Quit"};
        new AlertDialog.Builder(this)
                .setTitle("Choose an option")
                .setItems(options, (dialog, which) -> {
                    switch (which) {
                        case 0: // Show items
                            showItems();
                            break;
                        case 1: // Send SMS
                            sendSMS();
                            break;
                        case 2: // Quit
                            finish();
                            break;
                    }
                })
                .show();
    }

    private void showItems() {
        Intent intent = new Intent(this, ItemListActivity.class);
        intent.putStringArrayListExtra("shoppingList", shoppingList);
        startActivity(intent);
    }

    private void sendSMS() {
        // Example phone number and message
        String phoneNumber = "1234567890"; // Replace with actual number
        String message = String.join(", ", shoppingList); // Create a message from the list items

        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.setData(Uri.parse("smsto:" + phoneNumber)); // This ensures only SMS apps respond
        smsIntent.putExtra("sms_body", message); // The message body

        // Check if there is an app that can handle this intent
        if (smsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(smsIntent);
        } else {
            Toast.makeText(this, "No SMS app found", Toast.LENGTH_SHORT).show();
        }
    }

}
