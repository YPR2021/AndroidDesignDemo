package com.example.yang.androiddesigndemo.TranslucentBarActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.yang.androiddesigndemo.MainActivity;
import com.example.yang.androiddesigndemo.R;

/**
 * TranslucentBar最好的实现方式
 */
public class TestTranslucentBarActivity extends TranslucentBarBaseActivity {
	private TextInputEditText mEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mEditText = (TextInputEditText) findViewById(R.id.et_text_input);
		//实用的输入法按键监听
		mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				 /*判断是否是“完成”键*/
				if (actionId == EditorInfo.IME_ACTION_DONE) {
                    /*隐藏软键盘*/
					InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
					if (imm.isActive()) {
						if (TextUtils.isEmpty(v.getText())) {
							mEditText.setError("不能为空~");
							imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
						}
						return true;
					}
				}
				return false;
			}
		});
		//添加文本的监听
		mEditText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (TextUtils.isEmpty(s))
					mEditText.setError("不能为空~");
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	@Override
	protected int getLayoutResId() {
		return R.layout.activity_test_translucent_bar;
	}

//	/**
//	 * 监听输入法按键
//	 *
//	 * @param event
//	 * @return
//	 */
//	@Override
//	public boolean dispatchKeyEvent(KeyEvent event) {
//		//如果是确定键
//		if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
//			InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//			if (inputMethodManager.isActive())
//				inputMethodManager.hideSoftInputFromWindow(TestTranslucentBarActivity.this.getCurrentFocus().getWindowToken(), 0);
//			if (TextUtils.isEmpty(mEditText.getText()))
//				mEditText.setError("不能为空~");
//		}
//		return super.dispatchKeyEvent(event);
//	}
}
