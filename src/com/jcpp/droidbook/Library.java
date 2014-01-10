package com.jcpp.droidbook;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jcpp.droidbook.dao.Book;
import com.jcpp.droidbook.dao.BookDao;
import com.jcpp.droidbook.dao.DaoSession;


public class Library extends Activity {

	private List<Book> bookList;
	private DaoSession ds;
    private BookDao bookDao;
    
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.library_layout);
	    
	    Intent i = new Intent();
	    ds = (DaoSession) i.getParcelableExtra("Session");
	    bookList = ds.getBookDao().getAll();
	    
	    final ListView list = (ListView) findViewById(R.id.listView1);
	    final ArrayList<String> titles = new ArrayList<String>();
	    for( int x = 0; x < bookList.size(); x++){
	    	
	    	titles.add(bookList.get(x).getTitle());
	    }
	    
	    final ArrayAdapter array = new ArrayAdapter(this, android.R.layout.simple_list_item_1,titles);
	    list.setAdapter(array);
	    /*
	    final StableArrayAdapter adapter = new StableArrayAdapter(this,
	        android.R.layout.simple_list_item_1, list);
	    

	    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	      @Override
	      public void onItemClick(AdapterView<?> parent, final View view,
	          int position, long id) {
	        final String item = (String) parent.getItemAtPosition(position);
	        view.animate().setDuration(2000).alpha(0)
	            .withEndAction(new Runnable() {
	              @Override
	              public void run() {
	                list.remove(item);
	                adapter.notifyDataSetChanged();
	                view.setAlpha(1);
	              }
	            });
	      }

	    });
	  }

	  private class StableArrayAdapter extends ArrayAdapter<String> {

	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	    public StableArrayAdapter(Context context, int textViewResourceId,
	        List<String> objects) {
	      super(context, textViewResourceId, objects);
	      for (int i = 0; i < objects.size(); ++i) {
	        mIdMap.put(objects.get(i), i);
	      }
	    }

	    @Override
	    public long getItemId(int position) {
	      String item = getItem(position);
	      return mIdMap.get(item);
	    }

	    @Override
	    public boolean hasStableIds() {
	      return true;
	    }

	  }*/

	}
}