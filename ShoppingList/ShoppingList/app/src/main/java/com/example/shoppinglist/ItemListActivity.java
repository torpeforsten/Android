package com.example.shoppinglist;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        ListView listViewItems = findViewById(R.id.listViewItems);
        ArrayList<String> shoppingList = getIntent().getStringArrayListExtra("shoppingList");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shoppingList);
        listViewItems.setAdapter(adapter);
    }
}
