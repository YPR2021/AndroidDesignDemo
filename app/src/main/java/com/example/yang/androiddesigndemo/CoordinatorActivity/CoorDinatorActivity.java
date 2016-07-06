package com.example.yang.androiddesigndemo.CoordinatorActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yang.androiddesigndemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ypr on 2016/7/2 9:19.
 * 描述:
 * TODO:
 */
public class CoordinatorActivity extends AppCompatActivity implements View.OnClickListener {
	private FloatingActionButton fab;
	private Toolbar mToolbar;
	private TabLayout mTabLayout;
	private ViewPager mViewPager;
	private String[] tabs = new String[]{"tab1", "tab2", "tab3"};
	private int messageShowCount = 0, gcCount = 5;
	private List<String> list;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_coordinator);
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);//如果你没有调用supportRequestWindowFeature(Window.FEATURE_NO_TITLE);,报错
		fab = (FloatingActionButton) findViewById(R.id.fab);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mTabLayout = (TabLayout) findViewById(R.id.tab);
		initData();
	}

	private void initData() {
		list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add("item" + i);
		}
		if (getSupportActionBar() != null)
			getSupportActionBar().setDisplayShowTitleEnabled(false);
		if (fab != null)
			fab.setOnClickListener(this);
		mToolbar.setLogo(R.mipmap.ic_launcher);
		mToolbar.setSubtitle("副标题");
		mToolbar.setTitle("首页");
		mToolbar.setSubtitleTextColor(Color.GREEN);
		mToolbar.setTitleTextColor(Color.BLUE);
		mToolbar.setNavigationIcon(R.mipmap.ic_drawer_home);
		mViewPager.setAdapter(new MyPagerAadapter());
		mTabLayout.setSelectedTabIndicatorColor(Color.BLUE);
		mTabLayout.setupWithViewPager(mViewPager);
	}

	private class MyPagerAadapter extends PagerAdapter {
		@Override
		public int getCount() {
			return tabs.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = LayoutInflater.from(CoordinatorActivity.this).inflate(R.layout.viewpager, null);
			container.addView(view);
			RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
			recyclerView.setHasFixedSize(true);
			recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
			recyclerView.setItemAnimator(new DefaultItemAnimator());
			recyclerView.setAdapter(new MyRecyclerAdapter());
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return tabs[position];
		}

		class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

			@Override
			public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
				View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
				return new MyViewHolder(view);
			}

			@Override
			public void onBindViewHolder(MyViewHolder holder, int position) {
				holder.tv.setText(list.get(position));
			}

			@Override
			public int getItemCount() {
				return list.size();
			}

			class MyViewHolder extends RecyclerView.ViewHolder {
				private TextView tv;
				public MyViewHolder(View itemView) {
					super(itemView);
					tv = (TextView) itemView.findViewById(R.id.tv_text);
				}
			}
		}
	}

	@Override
	public void onClick(View v) {
		if (v == fab)
			count();
		Snackbar.make(v, "结束Activity", Snackbar.LENGTH_SHORT)
				.setAction("Finish", new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//Finish
						finish();
					}
				}).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//这里是处理menu中选中item的地方
		int id = item.getItemId();
		if (id == R.id.action_setting)
			Toast.makeText(this, "点击了Setting", Toast.LENGTH_SHORT).show();
		else if (id == R.id.action_search)
			Toast.makeText(this, "点击了Search", Toast.LENGTH_SHORT).show();
		else if (id == R.id.action_notification)
			Toast.makeText(this, "点击了Notification", Toast.LENGTH_SHORT).show();
		return super.onOptionsItemSelected(item);
	}

	/**
	 * 查看源码知道每次Snack bar一次系统就会参数一个snake bar实例,大概占用0.1MB内存
	 * 所以多提醒垃圾回收器回收
	 */
	private void count() {
		messageShowCount++;
		if (messageShowCount >= gcCount) {
			System.gc();
			messageShowCount = 0;
		}
	}
}
