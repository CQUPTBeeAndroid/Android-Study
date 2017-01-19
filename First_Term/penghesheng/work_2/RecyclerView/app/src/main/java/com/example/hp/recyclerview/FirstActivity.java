package com.example.hp.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by HP on 2017/1/19.
 */

public class FirstActivity extends Activity {

    public static void actionStart(Context context, String data1, int data2) {
        Intent intent = new Intent(context, FirstActivity.class);
        intent.putExtra("name", data1);
        intent.putExtra("imageID", data2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Intent intent = getIntent();
        TextView textView = (TextView) findViewById(R.id.text_name);
        textView.setText(intent.getStringExtra("name"));
        TextView textView1 = (TextView) findViewById(R.id.text_view);
        textView1.setText("This is " + intent.getStringExtra("name"));
    }
}
