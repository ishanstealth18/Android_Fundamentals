package com.lightwave.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView showOrderView;
    private RadioButton sameDayButton;
    private RadioButton nextDayButton;
    private RadioButton pickupButton;
    private EditText phoneText;
    public static final String logTag = OrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        showOrderView = findViewById(R.id.order_textview);
        Intent intent = getIntent();
        String displayOrder = intent.getStringExtra(MainActivity.EXTRA_MSG);
        showOrderView.setText(displayOrder);

        phoneText  = findViewById(R.id.phone_text);
        if (phoneText != null)
        {
            phoneText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    boolean handled = false;
                    if(i == EditorInfo.IME_ACTION_SEND)
                    {
                        dialNumber();
                        handled = true;
                    }
                    return handled;
                }
            });
        }
        else
        {
            Log.d(logTag,"Phone view did not find!!");
        }



        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }

    public void dialNumber()
    {
        String phoneNumber = phoneText.getText().toString();
        Log.d(logTag, "Phone: "+phoneNumber);

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: "+phoneNumber));
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
        else
        {
            Log.d(logTag, "Dial activity not resolved!!");
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {

            switch (view.getId()) {
                case (R.id.sameday):
                    displayToast(getString(R.string.same_day_messenger_service));
                    break;
                case (R.id.nextday):
                    displayToast(getString(R.string.next_day_ground_delivery));
                    break;
                case (R.id.pickup):
                    displayToast(getString(R.string.pick_up));
                    break;
                default:

            }



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        displayToast(adapterView.getItemAtPosition(i).toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
