package com.example.wanjian.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.wanjian.counter.R.id.formula_area;

public  class MainActivity extends AppCompatActivity  implements View.OnClickListener{
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
    Button btn_c;
    Button btn_del;
    Button btn_div;
    Button btn_dot;
    Button btn_mul;
    Button btn_sub;
    Button btn_equ;
    Button btn_add;
    TextView formula_area;
    boolean clear_flag=true;//清空标识

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //实例化显示显示框
        formula_area=(TextView)findViewById(R.id.formula_area);


        //实例化按钮
        btn_0=(Button)findViewById(R.id.btn_0);
        btn_1=(Button)findViewById(R.id.btn_1);
        btn_2=(Button)findViewById(R.id.btn_2);
        btn_3=(Button)findViewById(R.id.btn_3);
        btn_4=(Button)findViewById(R.id.btn_4);
        btn_5=(Button)findViewById(R.id.btn_5);
        btn_6=(Button)findViewById(R.id.btn_6);
        btn_7=(Button)findViewById(R.id.btn_7);
        btn_8=(Button)findViewById(R.id.btn_8);
        btn_9=(Button)findViewById(R.id.btn_9);
        btn_del=(Button)findViewById(R.id.btn_del);
        btn_div=(Button)findViewById(R.id.btn_div);
        btn_dot=(Button)findViewById(R.id.btn_dot);
        btn_mul=(Button)findViewById(R.id.btn_mul);
        btn_sub=(Button)findViewById(R.id.btn_sub);
        btn_equ=(Button)findViewById(R.id.btn_equ);
        btn_add=(Button)findViewById(R.id.btn_add);
        btn_c=(Button)findViewById(R.id.btn_c);

        //设置按钮的点击事件
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
        btn_del.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_equ.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_c.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        String str=formula_area.getText().toString(); //获取显示屏的内容
        switch (view.getId()){
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
            case R.id.btn_dot:
                if (clear_flag){
                    clear_flag=false;
                    str="";
                    formula_area.setText("");
                }
                formula_area.setText(str+((Button)view).getText());
                break;
            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_mul:
            case R.id.btn_div:
                if (clear_flag){
                    clear_flag=false;
                    str="";
                    formula_area.setText("");
                }
                formula_area.setText(str+" "+((Button)view).getText()+" ");
                break;
            case R.id.btn_del:
                if (str.contains(" + ")||str.contains(" - ")||str.contains(" × ")||str.contains(" ÷ ")){
                    formula_area.setText(str.substring(0,str.length()-3));
                } else if(str!=null&&!str.equals(""));{
                   try{
                       formula_area.setText(str.substring(0,str.length()-1));
                   }
                   catch(Exception e){
                       return;
                   }
            }
                break;
            case R.id.btn_c:
                clear_flag=false;
                str="";
                formula_area.setText("");
                break;
            case R.id.btn_equ:
                if (str==null||equals("")){
                    return;
                }
                getResult();
                break;
        }
    }


    //等号，运算结果
    private void getResult(){
        String exp=formula_area.getText().toString();    ///获取显示屏的内容
        if(exp==null||exp.equals("")){
            return;
        }
        if (!exp.contains(" ")){
            return;
        }            //无运算符，故不进行运算
        if (clear_flag){
            clear_flag=false;
            return;
        }
        clear_flag=true;
        double result=0;
        String s1=exp.substring(0,exp.indexOf(" "));
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);  //截取运算符
        String s2=exp.substring(exp.indexOf(" ")+3);

        //当s1和s2都不为空的时候，对s1和s2进行加减乘除运算
        if (!s1.equals("")&&!s2.equals("")){
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2);
            if (op.equals("+")) {
                result=d1+d2;
            }else if(op.equals("-")){
                result=d1-d2;
            }else if (op.equals("×")){
                result=d1*d2;
            }else if (op.equals("÷")){
                if(d2==0){
                    result=0;
                }else
                    result=d1/d2;
            }
            //如果s1和s2中都包含小数点且没有除号时，结果一定为int型
            if (!s1.contains(".")&&!s2.contains(".")&&!op.contains("÷")){
                int r=(int)result;
                formula_area.setText(r+"");
            }else {
                formula_area.setText(result+"");
            }

         //当s1不为空s2为空的时候，不进行计算
        }else if (!s1.equals("")&&s2.equals("")){
            formula_area.setText(exp);

            //当s1为空s2不为空的时候，进行计算并返回值
        }else if (s1.equals("")&&!s2.equals("")){
            double d2=Double.parseDouble(s2);
            if (op.equals("+")) {
                result=0+d2;
            }else if(op.equals("-")){
                result=0-d2;
            }else if (op.equals("÷")){
                result=0;
            }else if (op.equals("÷")){
                result=0;
            }
            if (!s1.contains(".")&&!s2.contains(".")){
                int r=(int)result;
                formula_area.setText(r+" ");
            }else {
                formula_area.setText(result+" ");
            }
            //当s1和s2都为空的时候，不进行计算直接返回其值
        }else if (s1.contains("")&&s2.contains("")){
            formula_area.setText("");
        }
    }


}





