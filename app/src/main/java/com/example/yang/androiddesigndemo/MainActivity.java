package com.example.yang.androiddesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;

import com.example.yang.androiddesigndemo.CoordinatorActivity.CoordinatorActivity;
import com.example.yang.androiddesigndemo.TranslucentBarActivity.TestTranslucentBarActivity;

public class MainActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
	private Button mButton1, mButton2, mButton3, mButton4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton1 = (Button) findViewById(R.id.translucent_bar);
		mButton2 = (Button) findViewById(R.id.coordinator_layout);
		mButton3 = (Button) findViewById(R.id.collapsing_toolbar);
		mButton4 = (Button) findViewById(R.id.navigation_view);
		mButton1.setOnClickListener(this);
		mButton2.setOnClickListener(this);
		mButton3.setOnClickListener(this);
		mButton4.setOnClickListener(this);

//		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//		drawer.setDrawerListener(toggle);
//		toggle.syncState();
//
//		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//		navigationView.setNavigationItemSelectedListener(this);
	}

	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
		} else if (id == R.id.nav_gallery) {

		} else if (id == R.id.nav_slideshow) {

		} else if (id == R.id.nav_manage) {

		} else if (id == R.id.nav_share) {

		} else if (id == R.id.nav_send) {

		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	@Override
	public void onClick(View v) {
		if (v == mButton1)
			startActivity(new Intent(MainActivity.this, TestTranslucentBarActivity.class));
		else if (v == mButton2)
			startActivity(new Intent(MainActivity.this, CoordinatorActivity.class));
		else if (v == mButton3)
			startActivity(new Intent(MainActivity.this, CoordinatorActivity.class));
		else if (v == mButton4)
			startActivity(new Intent(MainActivity.this, CoordinatorActivity.class));
	}
}
