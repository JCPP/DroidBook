package com.jcpp.droidbook.api.goodReads;

import java.io.IOException;

import org.jsoup.helper.HttpConnection.Response;
import org.jsoup.nodes.Document;

import com.jcpp.droidbook.dao.Author;
import com.jcpp.droidbook.dao.Book;

public class GoodReadsManager{

	private static GoodReadsManager instance = null;

	private static Response response = null;
	private static Document doc = null;
	private static String body = null;

	private GoodReadsManager(){

	}

	public static GoodReadsManager getManager(){
		if(instance == null){
			instance = new GoodReadsManager();
		}
		return instance;
	}

	/**
	 * This method provides the book by its code.
	 * @param code Code of book
	 * @return
	 * @throws IOException
	 */
	public Book getBookByCode(String code) throws IOException {
		Book book = null;
		ApiBook apiBook = new ApiBook();
		book = apiBook.getBookByCode(code);

		return book;
	}

	/**
	 * This method provides the author by its id.
	 * @param id GoodReads id of the author.
	 * @return
	 * @throws DocumentException
	 */
	public Author getAuthorById(String id) {
		Author author = null;
		ApiAuthor apiAuthor = new ApiAuthor();
		author = apiAuthor.getAuthorById(id);

		return author;
	}

	/**
	 * This method provides a Book's list of authors by its code.
	 * @param code Code of book
	 * @return
	 * @throws DocumentException
	 */
	public Author getAuthorByCode(String code) {
		Author author = new Author();
		ApiAuthor apiAuthor = new ApiAuthor();
		author = apiAuthor.getAuthorByBookCode(code);

		return author;
	}

	public static Document getDoc() {
		return doc;
	}

	public static void setDoc(Document doc) {
		GoodReadsManager.doc = doc;
	}


	public static String getBody() {
		return body;
	}


	public static void setBody(String body) {
		GoodReadsManager.body = body;
	}

	public static Response getResponse() {
		return response;
	}

	public static void setResponse(Response response) {
		GoodReadsManager.response = response;
	}
}