package com.example.user.project;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user on 2018/4/10.
 */

public class ViewAdapter extends BaseAdapter {

    private String[][] ElementsData;
    private LayoutInflater inflater;
    private int indentionBase;

    static class ViewHolder{
        LinearLayout rlBorder;
        TextView Date;
        TextView ID;
    }

    public ViewAdapter(String[][] data,LayoutInflater inflater){
        this.ElementsData = data;
        this.inflater = inflater;
        indentionBase = 100;
    }

    @Override
    public int getCount() {
        return ElementsData.length;
    }

    @Override
    public Object getItem(int position) {
        return ElementsData[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView!=null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list,null);
            holder.Date = (TextView)convertView.findViewById(R.id.date);
            holder.ID = (TextView)convertView.findViewById(R.id.stu_id);
            holder.rlBorder = (LinearLayout)convertView.findViewById(R.id.llBorder);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        if (true){
            holder.Date.setText(ElementsData[position][0]);
            holder.ID.setText(ElementsData[position][1]);
            holder.rlBorder.setBackgroundColor(Color.parseColor("#FF77E9AE"));
        }
        return convertView;
    }
}
