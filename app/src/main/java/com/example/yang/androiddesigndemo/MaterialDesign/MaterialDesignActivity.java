package com.example.yang.androiddesigndemo.MaterialDesign;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yang.androiddesigndemo.CollapsingToolbarActivity.CollapsingToolbarActivity;
import com.example.yang.androiddesigndemo.R;
import com.example.yang.androiddesigndemo.TranslucentBarActivity.TranslucentBarBaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ypr on 2016/7/4 16:54.
 * 描述:
 * TODO:
 */
public class MaterialDesignActivity extends TranslucentBarBaseActivity implements NavigationView.OnNavigationItemSelectedListener {
	private Toolbar mToolbar;
	private ViewPager mViewPager;
	private DrawerLayout drawer;
	private List<String> mList;
	private String[] tabs = new String[]{"tab1", "tab2", "tab3"};
	private TabLayout mTab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);
		if (getSupportActionBar() != null)
			getSupportActionBar().setDisplayShowTitleEnabled(false);
		mToolbar.setTitle("首页");
		mTab = (TabLayout) findViewById(R.id.tab);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		if (fab != null)
			fab.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Snackbar.make(v, "关闭Activity", Snackbar.LENGTH_SHORT).setAction("finish", new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							//点击finish后的操作
							finish();
							Toast.makeText(MaterialDesignActivity.this, "click", Toast.LENGTH_SHORT).show();
						}
					}).show();
				}
			});
		drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = (NavigationView) findViewById(R.id.material_nav_view);
		navigationView.setNavigationItemSelectedListener(this);
		initData();
	}

	private void initData() {
		mList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			mList.add("item" + i);
		}
		mViewPager.setAdapter(new MyAdapter());
		mTab.setSelectedTabIndicatorColor(Color.BLACK);
		mTab.setTabTextColors(Color.BLACK, Color.WHITE);
		mTab.setupWithViewPager(mViewPager);
	}

	/**
	 * 返回键的监听
	 */
	@Override
	public void onBackPressed() {
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	protected int getLayoutResId() {
		return R.layout.activity_material;
	}

	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (id == R.id.nav_camera) {
			// Handle the camera action
			Toast.makeText(this, "click camera", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.nav_gallery) {
			Toast.makeText(this, "click gallery", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.nav_slideshow) {
			Toast.makeText(this, "click slideshow", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.nav_manage) {
			Toast.makeText(this, "click manage", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.nav_share) {
			Toast.makeText(this, "click share", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.nav_send) {
			Toast.makeText(this, "click send", Toast.LENGTH_SHORT).show();
		}
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	private class MyAdapter extends PagerAdapter {
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
			View view = LayoutInflater.from(container.getContext()).inflate(R.layout.viewpager, null);
			RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
			recyclerView.setHasFixedSize(true);
			recyclerView.setLayoutManager(new LinearLayoutManager(MaterialDesignActivity.this));
			recyclerView.setItemAnimator(new DefaultItemAnimator());
			recyclerView.setAdapter(new MyRVAdapter());
			container.addView(view);
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

		private class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.MyHolder> {
			@Override
			public MyRVAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
				View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
				return new MyHolder(view);
			}

			@Override
			public void onBindViewHolder(MyRVAdapter.MyHolder holder, int position) {
				holder.tv.setText(mList.get(position));
			}

			@Override
			public int getItemCount() {
				return mList.size();
			}

			public class MyHolder extends RecyclerView.ViewHolder {
				private TextView tv;

				public MyHolder(View itemView) {
					super(itemView);
					tv = (TextView) itemView.findViewById(R.id.tv_text);
				}
			}
		}
	}
}
