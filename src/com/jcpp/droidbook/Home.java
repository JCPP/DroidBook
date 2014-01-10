package com.jcpp.droidbook;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.jcpp.droidbook.dao.Book;
import com.jcpp.droidbook.dao.BookDao;
import com.jcpp.droidbook.dao.DaoMaster;
import com.jcpp.droidbook.dao.DaoMaster.DevOpenHelper;
import com.jcpp.droidbook.dao.DaoSession;

public class Home extends Activity {

	private SQLiteDatabase db;

    private List<Book> bookList;

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private BookDao bookDao;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		 DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "DroidbookDB", null);
	        db = helper.getWritableDatabase();
	        daoMaster = new DaoMaster(db);
	        daoSession = daoMaster.newSession();
	        	
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
	    	intentLib.putExtra("Session", (Parcelable)daoSession);
	    	Home.this.startActivity(intentLib);
	    	
	    	Log.i("Content","Library");
	    }
	   };


}
