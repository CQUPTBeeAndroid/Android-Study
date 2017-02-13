package com.example.hp.wechat.FragmentSecondActivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hp.wechat.R;

public class Frag2_SecondActivity extends AppCompatActivity {

    public static void actionStart(Context context, String data1, int data2) {
        Intent intent = new Intent(context, Frag2_SecondActivity.class);
        intent.putExtra("name", data1);
        intent.putExtra("imageID", data2);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag2__second);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        Intent intent = getIntent();
        TextView textView = (TextView) findViewById(R.id.text_name);
        textView.setText(intent.getStringExtra("name"));
        TextView textView1 = (TextView) findViewById(R.id.text_view);
        textView1.setText("This is " + intent.getStringExtra("name"));
    }
}
