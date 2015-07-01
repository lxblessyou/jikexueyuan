package com.example.admin.getcontacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2015-07-01.
 */
public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<Contacts> list = new ArrayList<Contacts>();

    public MyAdapter(Context context, List<Contacts> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contacts contacts= list.get(position);
        ViewHold viewHold = null;
        if (convertView == null) {
            viewHold = new ViewHold();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_list_contacts, null);
            viewHold.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHold.tvNumber = (TextView) convertView.findViewById(R.id.tv_number);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        viewHold.tvName.setText(contacts.getName());
        viewHold.tvNumber.setText(contacts.getNumber());
        return convertView;
    }

    private class ViewHold {
        TextView tvName;
        TextView tvNumber;
    }
}
