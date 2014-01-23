package com.jcpp.droidbook;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Shelves extends Activity {

	 
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.activity_shelves);
	 }

	 private TextView createNewTextView(String text) {
	     final LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	     final TextView textView = new TextView(this);
	     textView.setLayoutParams(lparams);
	     textView.setText(text);
	     return textView;
	 }
	 
	 public void onClick(View v){
		 LinearLayout hiddenLayout = (LinearLayout)findViewById(R.id.linearLayoutX1);
		 LinearLayout myLayout = (LinearLayout)findViewById(R.id.linear);
		 View hiddenInfo = getLayoutInflater().inflate(R.layout.shelve_single_category, myLayout, false);
		 myLayout.addView(createNewTextView("New Category"));
		 myLayout.addView(hiddenInfo);
	 }
	 
	 public void onAdd(View v){
		 LinearLayout wrapper = (LinearLayout) findViewById(R.id.linearLayoutX1);
		 
		 View inflatedView = LayoutInflater.from(this).inflate(R.id.textView1, wrapper, false);
		 wrapper.addView(inflatedView);
		    
	 }
}
