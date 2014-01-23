package com.jcpp.droidbook;

import android.os.Bundle;
import android.app.Activity;
import android.text.InputFilter.LengthFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CodeInput extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_code_input);
		
		Button confirm = (Button) findViewById(R.id.button1);
		confirm.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				EditText txt = (EditText) findViewById(R.id.editText1);
				txt.setText("");
				String value = txt.getText().toString();
				
				Toast.makeText(getApplicationContext(), "Searching...", Toast.LENGTH_LONG).show();			
				
			}
			
		});
		Button clean = (Button) findViewById(R.id.button2);
		clean.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				
				EditText txt = (EditText) findViewById(R.id.editText1);
				txt.setText("");
				
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.layout.activity_code_input, menu);
		return true;
	}

}
