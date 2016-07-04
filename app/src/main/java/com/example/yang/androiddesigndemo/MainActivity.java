package com.example.yang.androiddesigndemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import com.example.yang.androiddesigndemo.CollapsingToolbarActivity.CollapsingToolbarActivity;
import com.example.yang.androiddesigndemo.CoordinatorActivity.CoordinatorActivity;
import com.example.yang.androiddesigndemo.MaterialDesign.MaterialDesignActivity;
import com.example.yang.androiddesigndemo.NavigationViewActivity.NavigationViewActivity;
import com.example.yang.androiddesigndemo.TranslucentBarActivity.TestTranslucentBarActivity;

public class MainActivity extends AppCompatActivity
		implements View.OnClickListener {
	private Button mButton1, mButton2, mButton3, mButton4,mButton5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton1 = (Button) findViewById(R.id.translucent_bar);
		mButton2 = (Button) findViewById(R.id.coordinator_layout);
		mButton3 = (Button) findViewById(R.id.collapsing_toolbar);
		mButton4 = (Button) findViewById(R.id.navigation_view);
		mButton5 = (Button) findViewById(R.id.material_design);
		mButton1.setOnClickListener(this);
		mButton2.setOnClickListener(this);
		mButton3.setOnClickListener(this);
		mButton4.setOnClickListener(this);
		mButton5.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if (v == mButton1)
			startActivity(new Intent(MainActivity.this, TestTranslucentBarActivity.class));
		else if (v == mButton2)
			startActivity(new Intent(MainActivity.this, CoordinatorActivity.class));
		else if (v == mButton3)
			startActivity(new Intent(MainActivity.this, CollapsingToolbarActivity.class));
		else if (v == mButton4)
			startActivity(new Intent(MainActivity.this, NavigationViewActivity.class));
		else if (v == mButton5)
			startActivity(new Intent(MainActivity.this, MaterialDesignActivity.class));
	}
}
