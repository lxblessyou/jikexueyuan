package com.example.admin.notes;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 2015-07-02.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private Cursor mCursor;
    private LayoutInflater mLayoutInflater;

    public MyAdapter(Context context, Cursor mCursor) {
        this.context = context;
        this.mCursor = mCursor;
    }

    @Override
    public int getCount() {
        return mCursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return mCursor.getPosition();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold viewHold = null;
        mLayoutInflater = LayoutInflater.from(context);
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.layout_list, null);
            viewHold = new ViewHold();
            convertView.setTag(viewHold);

            viewHold.image = (ImageView) convertView.findViewById(R.id.img_list_image);
            viewHold.video = (ImageView) convertView.findViewById(R.id.img_list_video);
            viewHold.content = (TextView) convertView.findViewById(R.id.tv_list_content);
            viewHold.date = (TextView) convertView.findViewById(R.id.tv_list_date);

        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        mCursor.moveToPosition(position);
        String content = mCursor.getString(mCursor.getColumnIndex(NotesDb.COLUMN_CONTENT));
        String date = mCursor.getString(mCursor.getColumnIndex(NotesDb.COLUMN_DATE));
        viewHold.content.setText(content);
        viewHold.date.setText(date);
        return convertView;
    }

    private class ViewHold {
        ImageView image;
        ImageView video;
        TextView content;
        TextView date;

    }
}
