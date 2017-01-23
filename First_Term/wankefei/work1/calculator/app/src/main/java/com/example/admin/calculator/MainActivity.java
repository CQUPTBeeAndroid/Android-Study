package com.example.admin.calculator;

import android.app.Activity;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener{
    Button btn_0;//数字按钮
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_point;
    Button btn_plus;
    Button btn_minus;
    Button btn_multiply;
    Button btn_divide;
    Button btn_del;
    Button btn_clear;
    Button btn_equal;
    EditText et_input;//显示输入的显示屏
    boolean clear_flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0= (Button) findViewById(R.id.btn_0);//初始化
        btn_1= (Button) findViewById(R.id.btn_1);
        btn_2= (Button) findViewById(R.id.btn_2);
        btn_3= (Button) findViewById(R.id.btn_3);
        btn_4= (Button) findViewById(R.id.btn_4);
        btn_5= (Button) findViewById(R.id.btn_5);
        btn_6= (Button) findViewById(R.id.btn_6);
        btn_7= (Button) findViewById(R.id.btn_7);
        btn_8= (Button) findViewById(R.id.btn_8);
        btn_9= (Button) findViewById(R.id.btn_9);
        btn_plus= (Button) findViewById(R.id.btn_plus);
        btn_minus= (Button) findViewById(R.id.btn_minus);
        btn_multiply= (Button) findViewById(R.id.btn_multiply);
        btn_divide= (Button) findViewById(R.id.btn_divide);
        btn_equal= (Button) findViewById(R.id.btn_equal);
        btn_point= (Button) findViewById(R.id.btn_point);
        btn_del= (Button) findViewById(R.id.btn_del);
        btn_clear= (Button) findViewById(R.id.btn_clear);
        et_input= (EditText) findViewById(R.id.et_input);//实例化显示屏
        //设置点击事件
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str=et_input.getText().toString();
        switch (v.getId()){
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if (clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+((Button)v).getText());
            break;
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                if (clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.btn_del:
                if (clear_flag){
                    clear_flag=false;
                    str="";
                    et_input.setText("");
                }else if (str != null && !str.equals("")){
                    et_input.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.btn_clear:
                clear_flag=false;
                str="";
                et_input.setText("");
            case R.id.btn_equal:
                getResult();
                break;
        }
    }
    private void getResult(){
        String exp=et_input.getText().toString();
        if (exp==null || exp.equals(" ")){
            return;
        }
        if (!exp.contains(" ")){
            return;
        }
        if (clear_flag){
            clear_flag=false;
            return;
        }
        clear_flag=true;
        Double result = 0d;
        String s1=exp.substring(0,exp.indexOf(" "));//运算符前面一个数字
        s1=s1.replace("\\s","");
        Log.d("TAG", "S1 ="+s1);
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        op=op.replaceAll("\\s","");
        Log.d("TAG", "op ="+op);
        String s2=exp.substring(exp.indexOf(" ")+3);
        s2=s2.replaceAll("\\s","");
        Log.d("TAG", "s2 ="+s2);
        if (!s1.equals("") && !s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                result = d1 + d2;
            } else if (op.equals("-")) {
                result = d1 - d2;
            } else if (op.equals("x")) {
                result = d1 * d2;
            } else if (op.equals("/")) {
                if (d2 == 0) {
                    result = 0d;
                } else {
                    result = d1 / d2;
                }
            }
            et_input.setText(result.toString());
        }else if (!s1.equals("") && s2.equals("")){
                et_input.setText(exp);
        }else if (s1.equals("") && !s2.equals("")){
                double d2= Double.parseDouble(s2);
                if (op.equals("+")){
                    result=0+d2;
                }else if (op.equals("-")){
                    result=0-d2;
                }else if (op.equals("x")){
                    result=0*d2;
                }else if (op.equals("/")){
                    result=0d;
            }
            et_input.setText(result.toString());
        }else {
            et_input.setText("");
            }
    }
}
