package com.example.olxtest;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TopListAdapter extends RecyclerView.Adapter<TopListAdapter.AdViewHolder>{

	private List<MyAd> mTopListItem;
	private Context mContext;
	public static class AdViewHolder extends RecyclerView.ViewHolder {

		TextView adCategory;
		TextView adName;
		ImageView adImage;
		TextView adPrice;
		
		public AdViewHolder(View itemView) {
			super(itemView);
			// TODO Auto-generated constructor stub
			adName = (TextView) itemView.findViewById(R.id.top_list_item_tv);
			adImage = (ImageView) itemView.findViewById(R.id.top_list_item_icon);
			adPrice = (TextView) itemView.findViewById(R.id.top_list_item_price);
		}
		
	}
	
	public TopListAdapter(Context context, List<MyAd> items) {
		mTopListItem = new ArrayList<MyAd>();
		mTopListItem = items;
		mContext = context;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return mTopListItem.size();
	}
	@Override
	public void onBindViewHolder(AdViewHolder adViewHolder, int i) {
		// TODO Auto-generated method stub
		//adViewHolder.adCategory.setText(mTopListItem.get(i).adCategory);
		adViewHolder.adName.setText(mTopListItem.get(i).adName);
		adViewHolder.adPrice.setText(String.valueOf(mTopListItem.get(i).adPrice));
		adViewHolder.adImage.setImageDrawable(mTopListItem.get(i).draw);
		
		
	}
	@Override
	public AdViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		View v = LayoutInflater.from(mContext).inflate(R.layout.top_list_item, arg0, false);
		AdViewHolder avh = new AdViewHolder(v);
		return avh;
	}
	
	@Override
	public void onAttachedToRecyclerView(RecyclerView recyclerView) {
		// TODO Auto-generated method stub
		super.onAttachedToRecyclerView(recyclerView);
	}

	
	
}
