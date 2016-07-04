package com.example.yang.androiddesigndemo.NavigationViewActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.example.yang.androiddesigndemo.R;

/**
 * Created by ypr on 2016/7/4 11:59.
 * 描述:
 * TODO:
 */
public class NavigationViewActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
	private Toolbar mToolbar;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_navigation);
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);//如果你没有调用supportRequestWindowFeature(Window.FEATURE_NO_TITLE);,报错

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_nav);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);
	}

	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_nav);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item) {
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if (id == R.id.nav_camera) {
			// Handle the camera action
			Toast.makeText(NavigationViewActivity.this, "click camera", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.nav_gallery) {
			Toast.makeText(NavigationViewActivity.this, "click gallery", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.nav_slideshow) {
			Toast.makeText(NavigationViewActivity.this, "click slideshow", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.nav_manage) {
			Toast.makeText(NavigationViewActivity.this, "click manage", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.nav_share) {
			Toast.makeText(NavigationViewActivity.this, "click share", Toast.LENGTH_SHORT).show();
		} else if (id == R.id.nav_send) {
			Toast.makeText(NavigationViewActivity.this, "click send", Toast.LENGTH_SHORT).show();
		}
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_nav);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
}
