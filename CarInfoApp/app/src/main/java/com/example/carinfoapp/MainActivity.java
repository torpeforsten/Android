package com.example.carinfoapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private CheckBox checkBoxCar;
    private EditText editTextCarAge;
    private Button buttonSave;
    private TextView textViewSummary;
    private ToggleButton toggle4wd;
    private RadioGroup radioGroupType;
    private View advancedLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextName = findViewById(R.id.et_name);
        checkBoxCar = findViewById(R.id.cb_owns_car);
        editTextCarAge = findViewById(R.id.et_car_age);
        buttonSave = findViewById(R.id.btn_save);
        textViewSummary = findViewById(R.id.tv_summary);
        toggle4wd = findViewById(R.id.toggle_4wd);
        radioGroupType = findViewById(R.id.radio_group_type);
        advancedLayout = findViewById(R.id.advanced_layout);

        // Set initial visibility of the radio group
        radioGroupType.setVisibility(View.GONE); // Initially hidden
        toggle4wd.setChecked(true); // Set initial toggle state
        advancedLayout.setVisibility(View.GONE); // Initially hide advanced options

        // Checkbox listener
        checkBoxCar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editTextCarAge.setEnabled(isChecked);
            if (!isChecked) {
                editTextCarAge.setText("");
            }
        });

        // Save button listener
        buttonSave.setOnClickListener(v -> saveData());

        // Toggle listener for 4WD
        toggle4wd.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Show or hide the radio group based on 4WD toggle state
            radioGroupType.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        });
    }

    private void saveData() {
        String name = editTextName.getText().toString();
        boolean ownsCar = checkBoxCar.isChecked();
        String carAge = editTextCarAge.getText().toString();
        boolean is4wd = toggle4wd.isChecked();
        int selectedTypeId = radioGroupType.getCheckedRadioButtonId();

        StringBuilder summaryBuilder = new StringBuilder();
        summaryBuilder.append("Name: ").append(name).append("\n");
        summaryBuilder.append("Owns a Car: ").append(ownsCar ? "Yes" : "No").append("\n");
        summaryBuilder.append("Age of Car: ").append(carAge).append("\n");

        if (is4wd) {
            summaryBuilder.append("Four Wheel Drive: ").append(is4wd ? "Yes" : "No").append("\n");

            if (selectedTypeId != -1) {
                RadioButton selectedType = findViewById(selectedTypeId);
                summaryBuilder.append("Type: ").append(selectedType.getText()).append("\n");
            } else {
                summaryBuilder.append("Type: Not Selected\n"); // Handle no selection
            }
        }

        textViewSummary.setText(summaryBuilder.toString());
        textViewSummary.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.advanced_options) {
            // Toggle the visibility of the advanced options group
            advancedLayout.setVisibility(advancedLayout.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
            // Ensure both elements are shown when advanced options are visible
            toggle4wd.setChecked(false); // Reset toggle when hiding
            radioGroupType.setVisibility(View.GONE); // Hide car type options when hiding advanced options
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
