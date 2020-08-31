package com.lightwave.dialogforalert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month);
        String month_day = Integer.toString(day);
        String month_year = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + month_day + "/" + month_year);

        Toast.makeText(this, getString(R.string.date) + dateMessage,
                Toast.LENGTH_SHORT).show();

    }

    public void processTimePickerResult(int hours, int minutes) {
        String hour_picker = Integer.toString(hours);
        String minutes_picker = Integer.toString(minutes);
        String timeMessage = (hour_picker +":" +minutes_picker);

        Toast.makeText(this, getString(R.string.time_picker_message) + timeMessage,
                Toast.LENGTH_SHORT).show();

    }



    public void onClickShowAlert(View view) {

        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
        myAlertBuilder.setTitle((R.string.alert_title));
        myAlertBuilder.setMessage((R.string.alert_message));

        myAlertBuilder.setPositiveButton((R.string.ok_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), getString(R.string.ok_alert_message),
                        Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.setNegativeButton((R.string.cancel_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), getString(R.string.cancel_alert_message),
                        Toast.LENGTH_SHORT).show();
            }
        });
        myAlertBuilder.show();
    }

    public void showDatePicker(View view) {

        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.datepicker));

    }

    public void timePicker(View view) {

        DialogFragment timeFragment = new TimePickerFragment();
        timeFragment.show(getSupportFragmentManager(),getString(R.string.time_picker_text));
    }
}
