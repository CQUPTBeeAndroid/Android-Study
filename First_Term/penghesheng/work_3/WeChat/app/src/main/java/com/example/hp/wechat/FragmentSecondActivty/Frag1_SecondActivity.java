package com.example.hp.wechat.FragmentSecondActivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.wechat.FragmentSecondActivty.Frag1_Msg.Msg;
import com.example.hp.wechat.FragmentSecondActivty.Frag1_Msg.MsgAdapter;
import com.example.hp.wechat.R;

import java.util.ArrayList;
import java.util.List;

public class Frag1_SecondActivity extends AppCompatActivity {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, Frag1_SecondActivity.class);
        context.startActivity(intent);
    }

    private List<Msg> mMsgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView mRecyclerView;
    private MsgAdapter mMsgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag1__second);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        initMsgs();  //初始化数据
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        mRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mMsgAdapter = new MsgAdapter(mMsgList);
        mRecyclerView.setAdapter(mMsgAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    mMsgList.add(msg);
                    mMsgAdapter.notifyItemChanged(mMsgList.size() - 1);  //当有消息时，刷新RecyclerView中的显示
                    mRecyclerView.scrollToPosition(mMsgList.size() - 1);  //将RecyclerView定位到最后一行
                    inputText.setText("");  //清空输入框的内容
                }
            }
        });
    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        mMsgList.add(msg1);

        Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
        mMsgList.add(msg2);

        Msg msg3 = new Msg("This is Tom Nice talking to you!", Msg.TYPE_RECEIVED);
        mMsgList.add(msg3);
    }
}
