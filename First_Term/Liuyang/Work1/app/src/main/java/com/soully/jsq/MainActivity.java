package com.soully.jsq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button_deng;
    private Button button_cheng;
    private Button button_chu;
    private Button button_jia;
    private Button button_jian;
    private Button button_dian;
    private Button button_clear;
    private Button button_delete;
    private Button button_zuo;
    private Button button_you;
    private TextView textView;
    double result = 0;//运算结果
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = (Button) findViewById(R.id.button_0);
        button1 = (Button) findViewById(R.id.button_1);
        button2 = (Button) findViewById(R.id.button_2);
        button3 = (Button) findViewById(R.id.button_3);
        button4 = (Button) findViewById(R.id.button_4);
        button5 = (Button) findViewById(R.id.button_5);
        button6 = (Button) findViewById(R.id.button_6);
        button7 = (Button) findViewById(R.id.button_7);
        button8 = (Button) findViewById(R.id.button_8);
        button9 = (Button) findViewById(R.id.button_9);
        button_cheng = (Button) findViewById(R.id.button_Cheng);
        button_chu = (Button) findViewById(R.id.button_Chu);
        button_clear = (Button) findViewById(R.id.button_Clear);
        button_jia = (Button) findViewById(R.id.button_Jia);
        button_jian = (Button) findViewById(R.id.button_Jian);
        button_dian = (Button) findViewById(R.id.button_Dian);
        button_deng = (Button) findViewById(R.id.button_DengYu);
        button_delete = (Button) findViewById(R.id.button_Delete);
        button_zuo = (Button) findViewById(R.id.button_Zuo);
        button_you = (Button) findViewById(R.id.button_You);
        textView = (TextView) findViewById(R.id.textView);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button_dian.setOnClickListener(this);
        button_deng.setOnClickListener(this);
        button_jian.setOnClickListener(this);
        button_jia.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_chu.setOnClickListener(this);
        button_cheng.setOnClickListener(this);
        button_delete.setOnClickListener(this);
        button_you.setOnClickListener(this);
        button_zuo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String string = textView.getText().toString();
        /*
        当result不为0 时，即进行过计算。
        使string和result初始化为0
         */
        if (result != 0){
            string = "0";
            result = 0;
        }
        switch (view.getId()){
            case  R.id.button_0:
                if (string.equals("0")){
                    textView.setText( "0");
                }else {
                    textView.setText(string + "0");}
                break;
            case R.id.button_1:
                if (string.equals("0")){
                    textView.setText( "1");
                }else{textView.setText(string+ "1");}
                break;
            case R.id.button_2:
                if (string.equals("0")){
                    textView.setText("2");
                }else{
                    textView.setText(string+ "2");}
                break;
            case R.id.button_3:
                if (string.equals("0")){
                    textView.setText( "3");
                }else{
                    textView.setText(string+ "3");}
                break;
            case R.id.button_4:
                if (string.equals("0")){
                    textView.setText( "4");
            }else{
                    textView.setText(string+ "4");}
                break;
            case R.id.button_5:
                if (string.equals("0")){
                    textView.setText( "5");
                }else{
                    textView.setText(string+ "5");}
                break;
            case R.id.button_6:
                if (string.equals("0")){
                    textView.setText( "6");
                }else{
                    textView.setText(string+ "6");}
                break;
            case R.id.button_7:
                if (string.equals("0")){
                    textView.setText( "7");
                }else{
                    textView.setText(string+ "7");}
                break;
            case R.id.button_8:
                if (string.equals("0")){
                    textView.setText( "8");
                }else{
                    textView.setText(string+ "8");}
                break;
            case R.id.button_9:
                if (string.equals("0")){
                    textView.setText( "9");
                }else{
                    textView.setText(string+ "9");}
                break;
            case R.id.button_Dian:
                textView.setText(string+".");
                break;
            case R.id.button_Jian:
                textView.setText(string +" "+"-"+" ");//运算符前后加空字符
                break;
            case R.id.button_Jia:
                textView.setText(string +" "+"+"+" ");
                break;
            case R.id.button_Cheng:
                textView.setText(string +" "+"*"+" ");
                break;
            case R.id.button_Chu:
                textView.setText(string +" "+"÷"+" ");
                break;
            case R.id.button_Clear:
                textView.setText("0");
                break;
            case R.id.button_Delete:
                if (string.length() == 1){
                    textView.setText("0");
                }else {
                    textView.setText(string.substring(0,string.length()-1));
                }
                break;
            case R.id.button_Zuo:
                if (string.equals("0")){
                    textView.setText( "(");
                }else{
                    textView.setText(string+ "(");}
                break;
            case R.id.button_You:
                if (string.equals("0")){
                    textView.setText( ")");
                }else{
                    textView.setText(string+ ")");}
                break;
            case R.id.button_DengYu:
                getResult();
                break;
        }
    }

    private void getResult() {
        String s = textView.getText().toString();
        /*
        如果不含空字符，即没有运算符，等于其本身。
         */
        if (!s.contains(" ")){
            textView.setText(String.valueOf(result));
        }
        /*
        如果式子含有括号
         */
        else if (s.indexOf("(") >= 0) {
            String a = s.substring(s.indexOf("(")+1,s.indexOf(")"));//取出括号里面的式子先进行计算。
            String a1 = a.substring(0,a.indexOf(" "));//识别空字符的位置，确定运算符的位置，将第一个数截取出来。
            String a2 = a.substring(a.indexOf(" ")+3);//s.indexOf（）为第一个检索到的空字符的位置
            String a3 = a.substring(a.indexOf(" ")+1,a.indexOf(" ")+2);//读出运算符
            double double1 = Double.parseDouble(a1) ;
            double double2 = Double.parseDouble(a2) ;
            if(!a2.equals(" ")){
                if (a3.equals("+")){
                    result = double1 + double2;
                }else if (a3.equals("-")){
                    result = double1 - double2;
                }else if (a3.equals("÷")){
                    if (double2 == 0){
                        result = 0;
                    }else {
                        result = double1/double2;
                    }
                }else if (a3.equals("*")){
                    result = double1*double2;
                }
            }else if (a2.equals(" ")){
                result = Double.parseDouble(a);
            }
            /*
            如果左括号在第一个位置，即以括号为整体的运算在左边。
             */
            if (s.indexOf("(") == 0) {
                String b2 = s.substring(s.indexOf(")")+4);
                String b3 = s.substring(s.indexOf(")")+2,s.indexOf(")")+3);
                double x2 =  Double.parseDouble(b2);
                if(!b2.equals(" ")){
                    if (b3.equals("+")){
                        result = result + x2;
                    }else if (b3.equals("-")){
                        result = result - x2;
                    }else if (b3.equals("÷")){
                        if (x2 == 0){
                            result = 0;
                        }else {
                            result = result/x2;
                        }
                    }else if (b3.equals("*")){
                        result = result*x2;
                    }
                    textView.setText(String.valueOf(result));
                }else if (b2.equals(" ")){
                    textView.setText(String.valueOf(result));
                }
            }
            /*
            如果左括号不在第一个位置，即以括号为整体的运算在右边.
             */
            else if (s.indexOf("(") > 0){
                String c1 = s.substring(0,s.indexOf(" "));
                String c3 = s.substring(s.indexOf(" ")+1,s.indexOf(" ")+2);
                double x1 =  Double.parseDouble(c1);
                String x2 = String.valueOf(result);
                if(!x2.equals(" ")){
                    if (c3.equals("+")){
                        result = x1 + result;
                    }else if (c3.equals("-")){
                        result = x1 - result;
                    }else if (c3.equals("÷")){
                        if (result == 0){
                            result = 0;
                        }else {
                            result = x1/result;
                        }
                    }else if (c3.equals("*")){
                        result = x1*result;
                    }
                    textView.setText(String.valueOf(result));
                }else if (x2.equals(" ")){
                    textView.setText(String.valueOf(result));
                }
            }
        }
        else{
            String s1 = s.substring(0,s.indexOf(" "));//识别空字符的位置，确定运算符的位置，将第一个数截取出来。
            String s2 = s.substring(s.indexOf(" ")+3);//s.indexOf（）为第一个检索到的空字符的位置
            String s3 = s.substring(s.indexOf(" ")+1,s.indexOf(" ")+2);//读出运算符
            double double1 = Double.parseDouble(s1) ;
            double double2 = Double.parseDouble(s2) ;
            if(!s2.equals(" ")){
                if (s3.equals("+")){
                    result = double1 + double2;
                }else if (s3.equals("-")){
                    result = double1 - double2;
                }else if (s3.equals("÷")){
                   if (double2 == 0){
                       result = 0;
                   }else {
                       result = double1/double2;
                   }
                }else if (s3.equals("*")){
                    result = double1*double2;
                }
                textView.setText(String.valueOf(result));
            }else if (s2.equals(" ")){
                textView.setText(s);
            }
        }
    }
}
