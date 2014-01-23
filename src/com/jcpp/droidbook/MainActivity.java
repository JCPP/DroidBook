package com.jcpp.droidbook;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.jcpp.droidbook.dao.DaoMaster;
import com.jcpp.droidbook.dao.DaoMaster.DevOpenHelper;
import com.jcpp.droidbook.dao.DaoSession;
import com.jcpp.droidbook.dao.NoteDao;

public class MainActivity extends Activity{

	private SQLiteDatabase db;
	private DaoMaster daoMaster;
    public static DaoSession daoSession;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		 DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "droidBook-db", null);
	        db = helper.getWritableDatabase();
	        daoMaster = new DaoMaster(db);
	        daoSession = daoMaster.newSession();
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
			
			Intent shelv = new Intent(MainActivity.this,Prefs.class);
			
			MainActivity.this.startActivity(shelv);
		}
		
		if(v == findViewById(R.id.textView5)){
			
		}
		
		if(v == findViewById(R.id.textView6)){
			
		}
		
	}
}