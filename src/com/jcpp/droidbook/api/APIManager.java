package com.jcpp.droidbook.api;

/**
 * Deve gestire tutte le API dei siti
 * chiamandole in ordine di efficienza 
 * e potrebbe tener traccia dei contenuti non trovati con dei log.
 * 
 * È una classe single-ton.
 */

import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;

import com.jcpp.droidbook.api.goodReads.GoodReadsManager;
import com.jcpp.droidbook.dao.Author;
import com.jcpp.droidbook.dao.Book;


public class APIManager {
	protected final String GR_KEY = "Ryk2YG5CcRzqA7OKfaAbw";
	private APIManager instance = null;
	private GoodReadsManager gr_manager = null;

	protected APIManager(){

	}

	/**
	 *
	 * @return The ApiManager instance.
	 */
	public APIManager getApiManager(){
		if(instance == null){
			instance = new APIManager();
		}
		return instance;
	}

	/**
	 * This method provides a book by its code.
	 * @param code
	 * @return
	 * @throws DocumentException
	 */
	public Book getBookByCode(String code) throws DocumentException{
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
	public List<Author> getListofAuthorsByBook(String code) throws DocumentException{
		List<Author> authors = new ArrayList<Author>();
		authors = gr_manager.getAuthorByCode(code);
		return authors;
	}
}

