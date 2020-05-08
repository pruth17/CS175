package edu.sjsu.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class PerAdapter extends ArrayAdapter<String> {
    String[] names;
    Context mContext;

    public PerAdapter(Context context, String[] countryNames) {
        super(context, R.layout.listview_item);
        this.names = countryNames;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyAdapter.ViewHolder mViewHolder = new MyAdapter.ViewHolder();
        if(convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listvi, parent, false);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        }
        else {
            mViewHolder = (MyAdapter.ViewHolder) convertView.getTag();
        }

        mViewHolder.mName.setText(names[position]);

        return convertView;
    }

    static class ViewHolder{
        TextView mName;

    }

}