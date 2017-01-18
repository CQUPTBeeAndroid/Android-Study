package com.count.asus.demo;

import android.app.Activity;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v7.widget.SearchView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_plus;
    Button btn_divide;
    Button btn_multiply;
    Button btn_minus;
    Button btn_point;
    Button btn_clear;
    Button btn_delete;
    Button btn_equle;
    EditText et_input;


    int clear_flag ; //清空标识
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_equle = (Button) findViewById(R.id.btn_equal);
        et_input = (EditText) findViewById(R.id.et_input);
        et_input.setCursorVisible(false);

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
        btn_divide.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_equle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = et_input.getText().toString();
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
                if(clear_flag==1){
                    clear_flag = 0;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str+((Button)v).getText());
                break;
            case R.id.btn_plus:
            case R.id.btn_divide:
            case R.id.btn_multiply:
            case R.id.btn_minus:
                if(clear_flag==1){
                    clear_flag = 0;
                    str = "";
                    et_input.setText("");
                }
                if(judgeOp()){     //判断是否有两个运算符
                    String s1 = str.substring(0, str.indexOf(" "));
                    et_input.setText(s1+" "+((Button)v).getText()+" ");
                }else{
                   et_input.setText(str+" "+((Button)v).getText()+" ");
                }
                break;
            case R.id.btn_clear:
                    clear_flag = 0;
                et_input.setText("");
                break;
            case R.id.btn_delete:
                //当刚进行完上一次运算时，del键也将数据清空
                if(clear_flag == 1){
                    clear_flag = 0;
                    str = "";
                    et_input.setText("");
                }
                Delete();
                break;
            case R.id.btn_equal:
                getResult();
                break;
        }
    }

    //判断是否有两个运算符，如果有，用后一个代替前一个
    public boolean judgeOp(){
        String jug = et_input.getText().toString();
        if(jug.contains(" ")){
            return true;
        }else{
            return flag;
        }
    }

    //删除
    public void Delete(){
        String del = et_input.getText().toString();
        if(!del.equals("") ) {
            if(del.contains(" ")){
                String s1 = del.substring(0, del.indexOf(" "));
                String op = del.substring(del.indexOf(" ") + 1, del.indexOf(" ") + 2);
                String s2 = del.substring(del.indexOf(" ") + 3);
                if(!s2.equals("")){
                    et_input.setText(del.substring(0, del.length() - 1));
                }else{
                    et_input.setText(del.substring(0, del.length() - 3));
                }
            }else{
                et_input.setText(del.substring(0, del.length() - 1));
            }
        }else{
            return;
        }
    }

    //运算结果
    public void getResult(){
        String exp = et_input.getText().toString();
        if(exp.equals(" ")){
            return;
        }else if(!exp.contains(" ")){
            return;
        }else if(exp.contains(" ")) {
            //防止连点多次“=”号
            if(clear_flag==1){
                clear_flag = 0;
            }
            clear_flag = 1;
            double result = 0;
            String s1 = exp.substring(0, exp.indexOf(" "));
            String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
            String s2 = exp.substring(exp.indexOf(" ") + 3);
            if (!s1.equals("") && !s2.equals("")) {
                double d1 = Double.parseDouble(s1);
                double d2 = Double.parseDouble(s2);
                if (op.equals("+")) {
                    result = d1 + d2;
                } else if (op.equals("-")) {
                    result = d1 - d2;
                } else if (op.equals("*")) {
                    result = d1 * d2;
                } else if (op.equals("/")) {
                    if (d2 == 0) {
                       result = 0;
                    } else {
                        result = d1 / d2;
                    }
                }
                if (!s1.contains(".") && !s2.contains(".") && !op.equals("/")) {
                    int res = (int) result;
                    et_input.setText(exp+"="+res);
                } else {
                    et_input.setText(exp+"="+result);
                }
                //clear_flag = true;
            } else if(exp.contains("=")){
                et_input.setText("");
            }
        }
    }
}
