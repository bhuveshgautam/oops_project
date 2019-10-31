package com.example.humsafar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.humsafar.Models.personalinfo;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<personalinfo> implements View.OnClickListener {
    private ArrayList<personalinfo> dataSet;
    Context mContext;

    private static class ViewHolder{
        TextView txtName;
        TextView txtPhone;
        TextView txtAddress;
    }

    public CustomAdapter(ArrayList<personalinfo> data, Context context){
        super(context, R.layout.list_items, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        personalinfo dataModel=(personalinfo) object;
    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        personalinfo dataModel = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_items, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.textname);
            viewHolder.txtPhone = (TextView) convertView.findViewById(R.id.textphone);
            viewHolder.txtAddress = (TextView) convertView.findViewById(R.id.textaddress);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.txtName.setText(dataModel.getname());
        viewHolder.txtPhone.setText(dataModel.getPhoneno());
        viewHolder.txtAddress.setText(dataModel.getAddress());

        return convertView;
    }
}
