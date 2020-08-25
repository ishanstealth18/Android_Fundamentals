package com.lightwave.shopping_list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView1,textView2;
    private static final String logTag = MainActivity.class.getSimpleName();
    public static final int REPLY_STATUS = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.itemText1);
        textView2 = findViewById(R.id.itemText2);

        if(savedInstanceState != null)
        {
            textView1.setText(savedInstanceState.getString("receiveItem1"));
            textView2.setText(savedInstanceState.getString("receiveItem2"));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("receiveItem1",textView1.getText().toString());
        outState.putString("receiveItem2",textView2.getText().toString());

    }

    public void requestButton(View view) {
        Intent intent = new Intent(this,Item_List.class);
        startActivityForResult(intent,REPLY_STATUS);
        //startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REPLY_STATUS)
        {
            if(resultCode == RESULT_OK)
            {
                String receiveString = data.getStringExtra(Item_List.EXTRA_ITEM_REPLY);
                if(receiveString.equals("Apple") )
                {
                    textView1.setText(receiveString);
                }
                else
                {
                    textView2.setText(receiveString);
                }

            }
            else
            {
                Log.d(logTag,"Error!!");
            }
        }
    }
}
