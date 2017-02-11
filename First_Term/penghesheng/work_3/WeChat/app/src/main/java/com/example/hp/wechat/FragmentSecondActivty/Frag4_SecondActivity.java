package com.example.hp.wechat.FragmentSecondActivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.hp.wechat.R;

public class Frag4_SecondActivity extends AppCompatActivity {
    public static void actionStart(Context context, String name) {
        Intent intent = new Intent(context, Frag4_SecondActivity.class);
        intent.putExtra("name", name);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag4__second);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
        String name = getIntent().getStringExtra("name");
        TextView nameText = (TextView) findViewById(R.id.name_text);
        nameText.setText(name);

        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        if (name.equals("setting1")) {
            webView.loadUrl("http://www.penghesheng.com");
        } else {
            webView.loadUrl("http://www.baidu.com");
        }
    }
}
