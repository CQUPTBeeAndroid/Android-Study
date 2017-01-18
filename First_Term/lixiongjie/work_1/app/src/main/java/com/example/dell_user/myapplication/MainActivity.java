package com.example.dell_user.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button quxiao;
    private Button houtui;
    private Button chen;
    private Button chu;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private Button bt7;
    private Button bt8;
    private Button bt9;
    private Button bt0;
    private Button btdian;
    private Button btdeng;
    private Button btjia;
    private Button btjian;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quxiao= (Button) findViewById(R.id.bt1);
        houtui= (Button) findViewById(R.id.bt2);
        chen= (Button) findViewById(R.id.bt3);
        chu= (Button) findViewById(R.id.bt4);
        bt7= (Button) findViewById(R.id.bt5);
        bt8= (Button) findViewById(R.id.bt6);
        bt9= (Button) findViewById(R.id.bt7);
        btjian= (Button) findViewById(R.id.bt8);
        bt4= (Button) findViewById(R.id.bt9);
        bt5= (Button) findViewById(R.id.bt10);
        bt6= (Button) findViewById(R.id.bt11);
        btjia= (Button) findViewById(R.id.bt12);
        bt1= (Button) findViewById(R.id.bt13);
        bt2= (Button) findViewById(R.id.bt14);
        bt3= (Button) findViewById(R.id.bt15);
        bt0= (Button) findViewById(R.id.bt16);
        btdian= (Button) findViewById(R.id.bt17);
        btdeng= (Button) findViewById(R.id.bt18);
        editText= (EditText) findViewById(R.id.edit);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        btjia.setOnClickListener(this);
        btjian.setOnClickListener(this);
        chen.setOnClickListener(this);
        chu.setOnClickListener(this);
        quxiao.setOnClickListener(this);
        houtui.setOnClickListener(this);
        bt0.setOnClickListener(this);
        btdeng.setOnClickListener(this);
        btdian.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String str=editText.getText().toString();
        switch (v.getId()){
            case R.id.bt5:
            case R.id.bt6:
            case R.id.bt7:
            case R.id.bt9:
            case R.id.bt10:
            case R.id.bt11:
            case R.id.bt13:
            case R.id.bt14:
            case R.id.bt15:
            case R.id.bt17:
            case R.id.bt16:
                editText.setText(str + ((Button) v).getText());
                break;

            case R.id.bt12:
            case R.id.bt8:
            case R.id.bt3:
            case R.id.bt4:
                editText.setText(str +""+((Button) v).getText()+"");
                break;

            case R.id.bt1:
                editText.setText("");break;
            case R.id.bt2:
                    if (str != null && !str.equals("")) {
                        editText.setText(str.substring(0, str.length() - 1));
                    break;
                }
            case R.id.bt18:
                jiguo();
                break;

            default:
                break;


        }

    }
    private void jiguo() {
        String exp = editText.getText().toString();
        double r = 0;
        int space = exp.indexOf(' ');
        String s1 = exp.substring(0, space);
        String op = exp.substring(space + 1, space + 2);
        String s2 = exp.substring(space + 3);
        double arg1 = Double.parseDouble(s1);
        double arg2 = Double.parseDouble(s2);
        if(op.equals("+")){
            r = arg1 + arg2;
        }else if(op.equals("-")){
            r = arg1 - arg2;
        }else if(op.equals("*")){
            r = arg1 * arg2;
        }else if(op.equals("/")){
            if (arg2 == 0)
            {
                r=0;
            }
            else
            {
                r = arg1 / arg2;
            }
            if(!s1.contains(".")&&!s2.contains(".")){
                int result = (int)r;
                editText.setText(result+"");
            }else{
                editText.setText(r+"");
            }
        }

    }
    }
