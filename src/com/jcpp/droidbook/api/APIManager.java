package com.jcpp.droidbook.api;

/**
 * Deve gestire tutte le API dei siti
 * chiamandole in ordine di efficienza 
 * e potrebbe tener traccia dei contenuti non trovati con dei log.
 * 
 * � una classe single-ton.
 */

import java.io.IOException;

import com.jcpp.droidbook.api.goodReads.GoodReadsManager;
import com.jcpp.droidbook.dao.Author;
import com.jcpp.droidbook.dao.Book;


public class APIManager {
	public final String GR_KEY = "Ryk2YG5CcRzqA7OKfaAbw";
	private static APIManager instance = null;
	private static GoodReadsManager gr_manager = null;
	

	private APIManager(){

	}

	/**
	 *
	 * @return The ApiManager instance.
	 */
	public static APIManager getApiManager(){
		gr_manager = GoodReadsManager.getManager();
		if(instance == null){
			instance = new APIManager();
		}
		return instance;
	}

	/**
	 * This method provides a book by its code.
	 * @param code
	 * @return
	 * @throws IOException 
	 */
	public Book getBookByCode(String code) throws IOException {
		Book book = new Book();
		
		book = gr_manager.getBookByCode(code);
		
		return book;
	}

	/**
	 * This method provides the Book' authors list.
	 * @param code
	 * @return
	 * @throws DocumentException
	 */
	public Author getAuthorByBookCode(String code){
		Author author = new Author();
		author = gr_manager.getAuthorByCode(code);
		
		return author;
	}
}

