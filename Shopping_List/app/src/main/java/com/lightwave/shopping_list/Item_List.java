package com.lightwave.shopping_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Item_List extends AppCompatActivity {

    public static final String EXTRA_ITEM_REPLY = "extra.ITEM.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__list);
    }

    public void saveItem1(View view) {
        String item1 = "Apple";
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(EXTRA_ITEM_REPLY,item1);
        setResult(RESULT_OK,intent);
        finish();

    }

    public void saveItem2(View view) {
        String item2 = "Rice";
        Intent intent2 = new Intent(this,MainActivity.class);
        intent2.putExtra(EXTRA_ITEM_REPLY,item2);
        setResult(RESULT_OK,intent2);
        finish();
    }
}
