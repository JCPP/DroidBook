package com.jcpp.droidbook;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class BookInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_info);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.layout.activity_book_info, menu);
		return true;
	}

}
