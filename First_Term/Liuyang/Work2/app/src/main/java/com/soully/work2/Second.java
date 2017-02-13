package com.soully.work2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Soully on 2017/1/16.
 */

public class Second extends AppCompatActivity{
    private TextView text;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Bundle bundle = new Bundle();
        bundle = this.getIntent().getExtras();
        s = bundle.getString("content");
        text = (TextView) findViewById(R.id.text);
        text.setText(s);
    }
}
