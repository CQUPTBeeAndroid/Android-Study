package com.example.hp.wechat.Demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hp.wechat.R;

import java.util.List;

/**
 * Created by HP on 2017/2/11.
 */

public class SettingsAdapter extends ArrayAdapter<Settings> {
    private int resourceId;

    public SettingsAdapter(Context context, int textViewResourceId, List<Settings> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Settings settings = getItem(position);  //获取当前项的Settings的实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder.settingsName = (TextView) view.findViewById(R.id.settings_name);
            view.setTag(viewHolder);  //将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();  //重新获取ViewHolder
        }
        viewHolder.settingsName.setText(settings.getName());
        return view;
    }

    class ViewHolder {
        TextView settingsName;
    }
}
