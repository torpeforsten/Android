package com.example.networksettings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView; // Import TextView
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView mainListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = findViewById(R.id.mainListView);
        String[] items = {"Encryption", "Basics", "Summary"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items) {
            @Override
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                // Get the view for the current item
                View view = super.getView(position, convertView, parent);

                // Cast the view to TextView
                TextView textView = (TextView) view; // Ensure view is a TextView

                // Set the text color and typeface
                textView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark)); // Make sure this color exists
                textView.setTypeface(null, android.graphics.Typeface.BOLD); // Set to bold

                return view;
            }
        };

        mainListView.setAdapter(adapter);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, EncryptionActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, BasicActivity.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, SummaryActivity.class);
                        break;
                    default:
                        return;
                }
                startActivity(intent);
            }
        });
    }
}
