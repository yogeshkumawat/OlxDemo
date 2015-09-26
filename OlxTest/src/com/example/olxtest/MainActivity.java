package com.example.olxtest;

import java.util.ArrayList;
import java.util.List;

import com.example.common.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends Activity {

	private RecyclerView mTopList;
	private LinearLayoutManager mLayoutManager;
	private Context mContext;
	private List<MyAd> mDummyData;
	private TopListAdapter mTopAdapter;
	private ListView mCategoryList;
	private List<Category> mDummyData2;
	private CategoryAdapter mCategoryAdapter;
	private SearchView mSearchView;
	private Button post;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		
		mTopList = (RecyclerView) findViewById(R.id.recycler_view);
		mCategoryList = (ListView) findViewById(R.id.category_list);
		
		mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
		mTopList.setLayoutManager(mLayoutManager);
		mTopList.setHasFixedSize(true);
		mTopList.getLayoutManager().scrollToPosition(mLayoutManager.findLastVisibleItemPosition()+1);
		
		fillDummyData();
		
		mTopAdapter = new TopListAdapter(mContext, mDummyData);
		mTopList.setAdapter(mTopAdapter);
		
		mCategoryAdapter = new CategoryAdapter(mContext, mDummyData2);
		mCategoryList.setAdapter(mCategoryAdapter);
		
		post = (Button) findViewById(R.id.fab);
		post.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(mContext, PostActivity.class);
				startActivity(i);
			}
		});
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		mSearchView = (SearchView) menu.findItem(R.id.search).getActionView();
		mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
			
			@Override
			public boolean onQueryTextSubmit(String arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(mContext, SearchActivity.class);
				i.putExtra("search_text", arg0);
				startActivity(i);
				return true;
			}
			
			@Override
			public boolean onQueryTextChange(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		return super.onOptionsItemSelected(item);
	}
	
	private void fillDummyData() {
		mDummyData = new ArrayList<MyAd>();
		mDummyData2 = new ArrayList<Category>();
		
		MyAd ad1 = new MyAd();
		ad1.adCategory = Utils.CATEGORY_MOBILE;
		ad1.adPrice = 10000.00;
		ad1.adName = "Apple iPhone";
		ad1.draw = getResources().getDrawable(R.drawable.mobile_dummy1);
		mDummyData.add(ad1);
		
		MyAd ad2 = new MyAd();
		ad2.adCategory = Utils.CATEGORY_MOBILE;
		ad2.adPrice = 10000.00;
		ad2.adName = "Apple iPhone";
		ad2.draw = getResources().getDrawable(R.drawable.mobile_dummy2);
		mDummyData.add(ad2);
		
		MyAd ad6 = new MyAd();
		ad6.adCategory = Utils.CATEGORY_CAR;
		ad6.adPrice = 40000.00;
		ad6.adName = "My car 2";
		ad6.draw = getResources().getDrawable(R.drawable.car_dummy2);
		mDummyData.add(ad6);
		
		MyAd ad7 = new MyAd();
		ad7.adCategory = Utils.CATEGORY_CAR;
		ad7.adPrice = 10000.00;
		ad7.adName = "My Car 3";
		ad7.draw = getResources().getDrawable(R.drawable.car_dummy4);
		mDummyData.add(ad7);
		
		MyAd ad3 = new MyAd();
		ad3.adCategory = Utils.CATEGORY_MOBILE;
		ad3.adPrice = 10000.00;
		ad3.adName = "Apple iPhone";
		ad3.draw = getResources().getDrawable(R.drawable.mobile_dummy3);
		mDummyData.add(ad3);
		
		MyAd ad4 = new MyAd();
		ad4.adCategory = Utils.CATEGORY_MOBILE;
		ad4.adPrice = 10000.00;
		ad4.adName = "Apple iPhone";
		ad4.draw = getResources().getDrawable(R.drawable.mobile_dummy3);
		mDummyData.add(ad4);
		
		MyAd ad5 = new MyAd();
		ad5.adCategory = Utils.CATEGORY_CAR;
		ad5.adPrice = 10000.00;
		ad5.adName = "My car 1";
		ad5.draw = getResources().getDrawable(R.drawable.car_dummy1);
		mDummyData.add(ad5);
		
		Category cat1 = new Category();
		cat1.draw = getResources().getDrawable(R.drawable.mobile_dummy4);
		cat1.mName = "Mobile";
		
		Category cat2 = new Category();
		cat2.draw = getResources().getDrawable(R.drawable.car);
		cat2.mName = "Car";
		
		Category cat3 = new Category();
		cat3.draw = getResources().getDrawable(R.drawable.electronics_accessories);
		cat3.mName = "Electronics";
		
		mDummyData2.add(cat1);
		mDummyData2.add(cat2);
		mDummyData2.add(cat3);
		
	}
}
