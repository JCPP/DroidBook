package com.jcpp.droidbook;

import java.io.IOException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcpp.droidbook.api.APIManager;
import com.jcpp.droidbook.dao.Book;
import com.jcpp.droidbook.dao.BookDao;

public class CodeInput extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_code_input);

		Button confirm = (Button) findViewById(R.id.button1);
		confirm.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				final EditText txt = (EditText) findViewById(R.id.editText1);
				txt.setText("");
				final String value = txt.getText().toString();
				Toast.makeText(getApplicationContext(), "Searching...", Toast.LENGTH_LONG).show();
				final APIManager apiManager = APIManager.getApiManager();

				class Connection extends AsyncTask{

					@Override
					protected Object doInBackground(Object... params) {
						try {
							Book book = null;
							BookDao bookDao = null;
							book = apiManager.getBookByCode(value);
							bookDao = MainActivity.daoSession.getBookDao();
							bookDao.insert(book);

							Log.e("PINGAS", book.getTitle());
							/*if(book != null){
								txt.setText("trovato");
							}else{
								txt.setText("non trovato");
							}*/

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return null;
					}
				}
				Connection conn = new Connection();
				conn.execute();
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
		//getMenuInflater().inflate(R.layout.activity_code_input, menu);
		return true;
	}

}
