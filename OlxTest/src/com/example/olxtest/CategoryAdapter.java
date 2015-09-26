package com.example.olxtest;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryAdapter extends BaseAdapter {

	private Context mContext;
	private List<Category> mList;
	public CategoryAdapter(Context context, List<Category> categorys) {
		// TODO Auto-generated constructor stub
		mList = new ArrayList<Category>();
		mList = categorys;
		mContext = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null)
			convertView = LayoutInflater.from(mContext).inflate(R.layout.app_item, parent, false);
		
		TextView tv = (TextView) convertView.findViewById(R.id.category_tv);
		ImageView icon = (ImageView) convertView.findViewById(R.id.category_icon);
		
		tv.setText(mList.get(position).mName);
		icon.setImageDrawable(mList.get(position).draw);
			
		return convertView;
	}

}
