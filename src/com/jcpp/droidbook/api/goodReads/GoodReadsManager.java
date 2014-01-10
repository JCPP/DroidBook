package com.jcpp.droidbook.api.goodReads;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;

import com.jcpp.droidbook.api.APIManager;
import com.jcpp.droidbook.dao.Author;
import com.jcpp.droidbook.dao.Book;

public class GoodReadsManager extends APIManager{
	
	protected Document doc = null;
	
	private ApiBook gr_book = null;
	private ApiAuthor gr_author = null;

	public GoodReadsManager(){
		
	}

	/**
	 * This method provides the book by its code.
	 * @param code Code of book
	 * @return
	 * @throws DocumentException
	 */
	@Override
	public Book getBookByCode(String code) throws DocumentException{
		Book book = null;
		book = gr_book.getBookByCode(code);
		
		return book;
	}

	/**
	 * This method provides the author by its id.
	 * @param id GoodReads id of the author.
	 * @return
	 * @throws DocumentException
	 */
	public Author getAuthorById(String id) throws DocumentException{
		Author author = null;
		author = gr_author.getAuthorById(id);
		
		return author;
	}

	/**
	 * This method provides a Book's list of authors by its code.
	 * @param code Code of book
	 * @return
	 * @throws DocumentException
	 */
	public List<Author> getAuthorByCode(String code) throws DocumentException{
		List<Author> authors = new ArrayList<Author>();
		authors = gr_author.getAuthorByCode(code);
		
		return authors;
	}
}