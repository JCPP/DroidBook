package com.jcpp.droidbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/*
		TextView tx = (TextView) findViewById(R.id.textView3);
		
		tx.setOnClickListener(new OnClickListener() {
			@Override public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, Library.class);
				startActivity(i);                        
			}
		});
		*/
	}
	
	public void onClick(View v){
		
		if(v == findViewById(R.id.textView1)){
			
		}
		
		if(v == findViewById(R.id.textView2)){
					Intent codeInput = new Intent(MainActivity.this,CodeInput.class);
					
					MainActivity.this.startActivity(codeInput);
				}
		
		if(v == findViewById(R.id.textView3)){
			
			Intent lib = new Intent(MainActivity.this,Library.class);
			
			MainActivity.this.startActivity(lib);
		}
		
		if(v == findViewById(R.id.textView4)){
			
			Intent shelv = new Intent(MainActivity.this,Shelves.class);
			
			MainActivity.this.startActivity(shelv);
		}
		
		if(v == findViewById(R.id.textView5)){
			
		}
		
		if(v == findViewById(R.id.textView6)){
			
		}
		
	}
}