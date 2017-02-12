package com.example.hp.claculatordemo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mButton_0;
    Button mButton_1;
    Button mButton_2;
    Button mButton_3;
    Button mButton_4;
    Button mButton_5;
    Button mButton_6;
    Button mButton_7;
    Button mButton_8;
    Button mButton_9;
    Button mButton_clear;  //清除按钮
    Button mButton_del; //删除按钮
    Button mButton_point; //小数点按钮
    Button mButton_plus;  //加号按钮
    Button mButton_minus;  //减号按钮
    Button mButton_multiply;  //乘号按钮
    Button mButton_divide;  //除号按钮
    Button mButton_equle;  //等于按钮
    EditText et_input;  //显示屏
    boolean clear_flag; //清空标识


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        //实例化
        mButton_0 = (Button) findViewById(R.id.button_0);
        mButton_1 = (Button) findViewById(R.id.button_1);
        mButton_2 = (Button) findViewById(R.id.button_2);
        mButton_3 = (Button) findViewById(R.id.button_3);
        mButton_4 = (Button) findViewById(R.id.button_4);
        mButton_5 = (Button) findViewById(R.id.button_5);
        mButton_6 = (Button) findViewById(R.id.button_6);
        mButton_7 = (Button) findViewById(R.id.button_7);
        mButton_8 = (Button) findViewById(R.id.button_8);
        mButton_9 = (Button) findViewById(R.id.button_9);
        mButton_clear = (Button) findViewById(R.id.button_clear);  //清除按钮
        mButton_del = (Button) findViewById(R.id.button_del); //删除按钮
        mButton_point = (Button) findViewById(R.id.button_point); //小数点按钮
        mButton_plus = (Button) findViewById(R.id.button_plus);  //加号按钮
        mButton_minus = (Button) findViewById(R.id.button_minus);  //减号按钮
        mButton_multiply = (Button) findViewById(R.id.button_multply);  //乘号按钮
        mButton_divide = (Button) findViewById(R.id.button_divide);  //除号按钮
        mButton_equle = (Button) findViewById(R.id.button_equal);  //等于按钮
        et_input = (EditText) findViewById(R.id.edit_input);  //显示屏

        mButton_0.setOnClickListener(this);
        mButton_1.setOnClickListener(this);
        mButton_2.setOnClickListener(this);
        mButton_3.setOnClickListener(this);
        mButton_4.setOnClickListener(this);
        mButton_5.setOnClickListener(this);
        mButton_6.setOnClickListener(this);
        mButton_7.setOnClickListener(this);
        mButton_8.setOnClickListener(this);
        mButton_9.setOnClickListener(this);
        mButton_clear.setOnClickListener(this);
        mButton_del.setOnClickListener(this);
        mButton_point.setOnClickListener(this);
        mButton_plus.setOnClickListener(this);
        mButton_minus.setOnClickListener(this);
        mButton_multiply.setOnClickListener(this);
        mButton_divide.setOnClickListener(this);
        mButton_equle.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String str = et_input.getText().toString();
        switch (v.getId()) {
            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
            case R.id.button_point:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str + ((Button)v).getText());
                break;

            case R.id.button_plus:
            case R.id.button_minus:
            case R.id.button_multply:
            case R.id.button_divide:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str + " " + ((Button)v).getText() + " ");  //前后加上一个空格
                break;

            case R.id.button_del:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    et_input.setText("");
                }else if (str != null && !str.equals(" ")) {
                    et_input.setText(str.substring(0,str.length()-1));
                }
                break;

            case R.id.button_clear:
                clear_flag = true;
                str = "";
                et_input.setText(" ");
                break;

            case R.id.button_equal:
                getResult();
                break;
        }

    }

    //等号计算
    private void getResult() {
        String exp = et_input.getText().toString();
        if (exp == null || exp.equals(" ")) {
            return;
        }
        if (!exp.contains(" ")) {
            return;
        }
        if (clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        double result = 0;
        String s1 = exp.substring(0, exp.indexOf(" "));  //运算符前面的字符串
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2); //运算符
        String s2 = exp.substring(exp.indexOf(" ") + 3);  //运算符后面的字符
        if (!s1.equals(" ") && !s2.equals(" ")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("＋")) {
                result = d1 + d2;
            } else if (op.equals("－")) {
                result = d1 - d2;
            } else if (op.equals("×")) {
                result = d1 * d2;
            } else if (op.equals("÷")) {
                if (d2 == 0) {
                    result = 0;
                } else {
                        result = d1 / d2;

                }
            }
            //如果都没有小数点并且不是除法，进行强转，或者都没有小数点且是整除时，进行强转
            if (!s1.contains(".") && !s2.contains(".") && !op.contains("÷") || (!s1.contains(".") && !s2.contains(".") && op.contains("÷") && d1 % d2 == 0)) {
                int r = (int) result;
                et_input.setText(r + "");
            } else {
                et_input.setText(result + "");
            }
        }else if (!s1.equals(" ") && s2.equals(" ")) {
                et_input.setText(exp);
        } else if (s1.equals(" ") && !s2.equals(" ")) {
            double d2 = Double.parseDouble(s2);
            if (op.equals("＋")) {
                result = 0 + d2;
            } else if (op.equals("－")) {
                result = 0 - d2;
            } else if (op.equals("×")) {
                result = 0;
            } else if (op.equals("÷")) {
                result = 0;
            }
            if (!s2.contains(".")) {
                int r = (int) result;
                et_input.setText(r + "");
            } else {
                et_input.setText(result + "");
            }
        }else {
            et_input.setText(" ");
        }
    }
}
