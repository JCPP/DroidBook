package com.jcpp.droidbook;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Input extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.isbn_input);
		
		
	}
	
	
	public void onClick(View v) {

		/*
	    if(v==findViewById(R.id.ISBNinput)){ 
	    	AlertDialog.Builder alert = new AlertDialog.Builder(this);

	    	alert.setTitle("ISBN: ");
	    	alert.setMessage("");

	    	// Set an EditText view to get user input 
	    	final EditText input = new EditText(this);
	    	alert.setView(input);

	    	alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	    	public void onClick(DialogInterface dialog, int whichButton) {
	    	  //int value = Integer.parseInt(input.getText().toString());
	    	  setContentView(R.layout.isbn_input);
	    	  }
	    	});

	    	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	    	  public void onClick(DialogInterface dialog, int whichButton) {
	    	    setContentView(R.layout.isbn_input);
	    	  }
	    	});

	    	alert.show();
	    }
	   };*/
	}
}
