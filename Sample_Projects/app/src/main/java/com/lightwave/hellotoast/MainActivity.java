
package com.lightwave.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView countView;
    private  TextView zeroButtonView;
    private int increaseCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countView = findViewById(R.id.show_count);
        zeroButtonView = findViewById(R.id.zeroButton);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this,R.string.toastMessage,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {

        increaseCount++;
        if(countView != null)
        {
            countView.setText(Integer.toString(increaseCount));
            zeroButtonView.setBackgroundColor(Color.RED);
        }
    }


    public void resetButton(View view) {
        increaseCount = 0;
        if(countView != null)
        {
            countView.setText(Integer.toString(increaseCount));
            zeroButtonView.setBackgroundColor(Color.GRAY);
            //zeroButtonView.setBackgroundColor(Color.parseColor("#aaa"));
        }
        else
        {
            Log.d("MainActivity","Null view");
        }
    }
}
