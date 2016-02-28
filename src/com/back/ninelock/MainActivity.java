package com.back.ninelock;

import com.back.ninelock.R;
import com.back.ninelock.view.ContentView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl);
		ContentView contentView =new ContentView(MainActivity.this);
		contentView.setParentView(frameLayout);
		
	}
}
