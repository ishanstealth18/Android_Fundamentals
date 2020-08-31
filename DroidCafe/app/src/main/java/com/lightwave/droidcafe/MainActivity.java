package com.lightwave.droidcafe;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MSG = "extra.MSG";
    private String orderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent sendItemIntent = new Intent(this,OrderActivity.class);
        switch (id)
        {
            case (R.id.action_contact):
                return true;
            case (R.id.action_favorites):
                displayToast(getString(R.string.action_favorites_message));
                return true;
            case (R.id.action_order):
                sendItemIntent.putExtra(EXTRA_MSG,R.string.action_order_message);
                startActivity(sendItemIntent);
                //displayToast(getString(R.string.action_order_message));
                return true;
            case (R.id.action_status):
                displayToast(getString(R.string.action_status_message));
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }

    public void showDonutOrder(View view) {
        orderMessage = getString(R.string.donut_order_message);
        //displayToast(orderMessage);

    }

    public void showIceCreamOrder(View view) {
        orderMessage = getString(R.string.ice_cream_order_message);
        //displayToast(orderMessage);
    }

    public void showFroyoOrder(View view) {
        orderMessage = getString(R.string.froyo_order_message);
        //displayToast(orderMessage);
    }

    public void orderItems(View view) {

        Intent donutIntent = new Intent(this,OrderActivity.class);
        donutIntent.putExtra(EXTRA_MSG,orderMessage);
        startActivity(donutIntent);
    }
}
