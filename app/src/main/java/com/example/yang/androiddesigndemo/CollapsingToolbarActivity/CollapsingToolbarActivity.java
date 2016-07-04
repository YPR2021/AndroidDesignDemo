package com.example.yang.androiddesigndemo.CollapsingToolbarActivity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.example.yang.androiddesigndemo.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ypr on 2016/7/4 9:19.
 * 描述:
 * TODO:
 */
public class CollapsingToolbarActivity extends AppCompatActivity implements View.OnClickListener {
	private Toolbar mToolbar;
	private FloatingActionButton mFab;
	private RecyclerView mRecyclerView;
	private List<String> list;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_collapsing);
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);
		mFab = (FloatingActionButton) findViewById(R.id.fab);
		mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		initData();
	}

	private void initData() {
		list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add("item" + i);
		}
		if (getSupportActionBar() != null)
			getSupportActionBar().setDisplayShowTitleEnabled(false);
		if (mFab != null)
			mFab.setOnClickListener(this);
		mToolbar.setTitle("首页");
		mRecyclerView.setHasFixedSize(true);
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.setAdapter(new MyAdapter());
	}

	@Override
	public void onClick(View v) {
		if (v == mFab) {
			Snackbar.make(v,"关闭Activity",Snackbar.LENGTH_SHORT).setAction("finish", new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					finish();
				}
			}).show();
		}
	}


	private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
		@Override
		public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
			return new MyViewHolder(view);
		}

		@Override
		public void onBindViewHolder(MyViewHolder holder, int position) {
			holder.tx.setText(list.get(position));
		}

		@Override
		public int getItemCount() {
			return list.size();
		}

		public class MyViewHolder extends RecyclerView.ViewHolder {
			private TextView tx;

			public MyViewHolder(View itemView) {
				super(itemView);
				tx = (TextView) itemView.findViewById(R.id.tv_text);
			}
		}
	}
}
