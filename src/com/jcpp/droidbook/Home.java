package com.jcpp.droidbook;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	/////////
	public void onClick(View v) {

	    if(v==findViewById(R.id.SearchBar)){ 
	            // doStuff
	            Intent intentScann = new Intent(Home.this , 
	            		Input.class);
	            Home.this.startActivity(intentScann);
	            Log.i("Content "," Main layout ");
	    }

	    if(v==findViewById(R.id.Input)){ 
	            // doStuff
	            Intent intentInput = new Intent(Home.this, 
	            		Input.class);

	            Home.this.startActivity(intentInput);

	            Log.i("Content ","ISBN input");

	    }
	    
	    if(v==findViewById(R.id.Library)){
	    	//doStuff
	    	Intent intentLib = new Intent(Home.this,
	    			Library.class);
	    	
	    	Home.this.startActivity(intentLib);
	    	
	    	Log.i("Content","Library");
	    }
	   };


}
