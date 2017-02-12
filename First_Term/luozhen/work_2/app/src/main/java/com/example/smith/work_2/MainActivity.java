package com.example.smith.work_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
                private Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0,btn_add,btn_mul,btn_sub,btn_dengyu,btn_chu,btn_c,btn_d;
                private TextView show;
                private List<ITEM> items=new ArrayList<ITEM>();
                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_main);
                    //获取控件
                    btn_1=(Button)findViewById(R.id.one);
                    btn_2=(Button)findViewById(R.id.two);
                    btn_3=(Button)findViewById(R.id.three);
                    btn_4=(Button)findViewById(R.id.four);
                    btn_5=(Button)findViewById(R.id.five);
                    btn_6=(Button)findViewById(R.id.six);
                    btn_7=(Button)findViewById(R.id.seven);
                    btn_8=(Button)findViewById(R.id.eight);
                    btn_9=(Button)findViewById(R.id.nine);
                    btn_0=(Button)findViewById(R.id.zero);
                    btn_add=(Button)findViewById(R.id.btn_add);
                    btn_sub=(Button)findViewById(R.id.btn_sub);
                    btn_mul=(Button)findViewById(R.id.btn_mul);
                    btn_chu=(Button)findViewById(R.id.btn_chu);
                    btn_dengyu=(Button)findViewById(R.id.btn_dengyu);
                    btn_c=(Button)findViewById(R.id.btn_c);
                    btn_d=(Button)findViewById(R.id.btn_d);
                    show=(TextView)findViewById(R.id.textView);
                    //设置监听器
                    btn_1.setOnClickListener(this);
                    btn_2.setOnClickListener(this);
                    btn_3.setOnClickListener(this);
                    btn_4.setOnClickListener(this);
                    btn_5.setOnClickListener(this);
                    btn_6.setOnClickListener(this);
                    btn_7.setOnClickListener(this);
                    btn_8.setOnClickListener(this);
                    btn_9.setOnClickListener(this);
                    btn_0.setOnClickListener(this);
                    btn_add.setOnClickListener(this);
                    btn_sub.setOnClickListener(this);
                    btn_mul.setOnClickListener(this);
                    btn_chu.setOnClickListener(this);
                    btn_dengyu.setOnClickListener(this);
                    btn_d.setOnClickListener(this);
                    btn_c.setOnClickListener(this);}
                @Override
                public void onClick(View v){
                    switch (v.getId()){
                        case R.id.one:
                            show.setText("1");break;

                        case R.id.two:
                            show.append("2");break;

                        case R.id.three:
                            show.append("3");break;

                        case R.id.four:
                            show.append("4");break;

                        case R.id.five:
                            show.append("5");break;

                        case R.id.six:
                            show.append("6");break;

                        case R.id.seven:
                            show.append("7");break;

                        case R.id.eight:
                            show.append("8");break;

                        case R.id.nine:
                            show.append("9");break;

                        case R.id.zero:
                                show.append("0");
                        case R.id.btn_d:
                            show.append(".");break;

                        case R.id.btn_add:
                            items.add(new ITEM(Double.parseDouble(show.getText().toString()),TYPES.number));
                            compute();
                            items.add(new ITEM(0,TYPES.add));
                            show.setText("   ");
                            break;

                        case R.id.btn_sub:
                            items.add(new ITEM(Double.parseDouble(show.getText().toString()),TYPES.number));
                            compute();
                            items.add(new ITEM(0,TYPES.sub));
                            show.setText("   ");
                            break;

                        case R.id.btn_mul:
                            items.add(new ITEM(Double.parseDouble(show.getText().toString()),TYPES.number));
                            compute();
                            items.add(new ITEM(0,TYPES.mul));
                            show.setText("   ");
                            break;

                        case R.id.btn_chu:
                            items.add(new ITEM(Double.parseDouble(show.getText().toString()),TYPES.number));
                            compute();
                            items.add(new ITEM(0,TYPES.chu));//o是操作符
                            show.setText("   ");
                            break;
                        case R.id.btn_dengyu:
                            items.add(new ITEM(Double.parseDouble(show.getText().toString()),TYPES.number));
                            compute();
                            show.setText(items.get(3).value+" ");
                            items.clear();
                            break;
                        case R.id.btn_c:
                            show.setText("   ");
                            items.clear();
                            break;
            }
    }
    public void compute(){
           if(items.size()>=3){
               double a=items.get(0).value;
               double b=items.get(2).value;
               int opt=items.get(1).type;
            switch (opt){
                case TYPES.add:items.add(new ITEM(a+b,TYPES.number));
                    break;
                case TYPES.mul:items.add(new ITEM(a*b,TYPES.number));
                    break;
                case TYPES.sub:items.add(new ITEM(a-b,TYPES.number));
                    break;
                case TYPES.chu:items.add(new ITEM(a/b,TYPES.number));
                    break;
            }
        }

    }

    }

