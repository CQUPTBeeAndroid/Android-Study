package com.soully.work3;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Soully on 2017/1/19.
 */

public class Second extends AppCompatActivity{
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_one);
        Bundle bundle = new Bundle();
        bundle = this.getIntent().getExtras();
        String s = bundle.getString("data");
        textView = (TextView) findViewById(R.id.content_one);
        textView.setText(s);
    }
}
