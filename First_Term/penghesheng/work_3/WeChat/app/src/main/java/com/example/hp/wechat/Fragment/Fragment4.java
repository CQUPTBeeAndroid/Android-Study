package com.example.hp.wechat.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.wechat.Demo.Settings;
import com.example.hp.wechat.Demo.SettingsAdapter;
import com.example.hp.wechat.FragmentSecondActivty.Frag4_SecondActivity;
import com.example.hp.wechat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 2017/2/11.
 */

public class Fragment4 extends Fragment implements AdapterView.OnItemClickListener {

    private List<Settings> mSettingsList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page4, null);
        initSettings();
        SettingsAdapter adapter = new SettingsAdapter(
                getActivity(), R.layout.settings_item, mSettingsList);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    private void initSettings() {
        for (int i = 1; i < 6; i++) {
            Settings settings = new Settings("setting" + i);
            mSettingsList.add(settings);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Settings settings = mSettingsList.get(position);
        Toast.makeText(getActivity(), settings.getName(), Toast.LENGTH_SHORT).show();
        Frag4_SecondActivity.actionStart(getActivity(), settings.getName());

    }
}