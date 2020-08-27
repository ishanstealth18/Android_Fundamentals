package com.lightwave.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private TextView showOrderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        showOrderView = findViewById(R.id.order_textview);
        Intent intent = getIntent();
        String displayOrder = intent.getStringExtra(MainActivity.EXTRA_MSG);
        showOrderView.setText(displayOrder);
    }
}
