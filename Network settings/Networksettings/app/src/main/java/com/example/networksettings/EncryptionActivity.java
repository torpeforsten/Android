package com.example.networksettings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EncryptionActivity extends AppCompatActivity {

    private ListView encryptionListView;
    private boolean[] selectedItems;
    private ArrayList<String> selectedItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);

        encryptionListView = findViewById(R.id.encryptionListView);
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
        selectedItems = new boolean[items.length];
        selectedItemList = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, items);
        encryptionListView.setAdapter(adapter);
        encryptionListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        encryptionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItems[position] = !selectedItems[position];
            }
        });

        // Return to main activity (you might want to use a button or similar)
        findViewById(R.id.backButton).setOnClickListener(v -> {
            // Handle the back navigation
            Intent intent = new Intent(EncryptionActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
