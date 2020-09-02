package com.lightwave.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;

    private TextView score1;
    private TextView score2;
    private int count = 0;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.night_mode)
        {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
// Recreate the activity for the theme change to take effect.
            recreate();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score1 = findViewById(R.id.score_1);
        score2 = findViewById(R.id.score_2);


    }

    public void decreaseCount(View view) {
        int viewId = view.getId();
        switch (viewId)
        {
            case (R.id.decreaseTeam1):
                mScore1--;
                score1.setText(Integer.toString(mScore1));
                break;
            case (R.id.decreaseTeam2):
                mScore2--;
                score2.setText(Integer.toString(mScore2));
                break;
        }
    }

    public void increaseCount(View view) {
        int viewId = view.getId();
        switch (viewId)
        {
            case (R.id.increaseTeam1):
                mScore1++;
                score1.setText(Integer.toString(mScore1));
                break;
            case (R.id.increaseTeam2):
                mScore2++;
                score2.setText(Integer.toString(mScore2));
                break;
        }

    }
}