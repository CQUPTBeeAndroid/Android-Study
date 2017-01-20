package com.list.asus.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        TextView textView ;
        Button returnButton ;
        textView = (TextView)findViewById(R.id.detail);
        returnButton = (Button)findViewById(R.id.returnButton);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        textView.setText("你想吃"+name+"?不给！！");

        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DetailActivity.this.finish();
            }
        });

    }
}
