package com.jcpp.droidbook.api.goodReads;

import java.sql.Date;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.jcpp.droidbook.dao.Book;

public class ApiBook extends GoodReadsManager{
	
	private final String BASE_PATH = "//GoodreadsResponse/book";
	

	
	/**
	 * This method provides the book builded, ready to be insert into database.
	 * @param code Isbn, isbn13 or Asin.
	 * @return Book builded.
	 */
	public Book getBookByCode(String code) throws DocumentException{
		Book book = new Book();
		
		// Get the SAXReader object
		SAXReader reader = new SAXReader();
		doc = reader.read(buildURL_book_isbn(code));
		if(/*condizione per cui c'è il libro*/ null == null){
			book.setIsbn(getIsbn());
			book.setIsbn13(getIsbn13());
			book.setAsin(getAsin());
			book.setTitle(getTitle());
			book.setDate(getDateofBook());
			book.setVote_avg(getAvg_vote());
			book.setNop(getNop());
			book.setEditor(getPublisher());
			book.setDescription(getDescription());		
		}

		return book.build();
	}
	
	/**
	 * This method provide Isbn from GoodReads.
	 * @return isbn code.
	 */
	private String getIsbn() {
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH);
		String title = null;

		for(Node node : nodes){
			Node field = node.selectSingleNode("isbn");
			title = field.getText();
		}
		return title;
	}

	/**
	 * This method provide Isbn13 from GoodReads.
	 * @return isbn13 code.
	 */
	private String getIsbn13() {
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH);
		String title = null;

		for(Node node : nodes){
			Node field = node.selectSingleNode("isbn13");
			title = field.getText();
		}
		return title;
	}

	/**
	 * This method provide Asin from GoodReads.
	 * @return asin code.
	 */
	private String getAsin() {
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH);
		String title = null;

		for(Node node : nodes){
			Node field = node.selectSingleNode("asin");
			title = field.getText();
		}
		return title;
	}

	/**
	 * This method provide title from GoodReads.
	 * @return Book's title.
	 */
	private String getTitle(){
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH);
		String title = null;

		for(Node node : nodes){
			Node field = node.selectSingleNode("title");
			title = field.getText();/*
			if(!field.getText().contains("#")){
				title = field.getText();
			}else{
				String[] title_full = field.getText().split("");
				title = title_full[0];
			}*/
		}
		return title;
	}

	/**
	 * This method provide date of book from GoodReads. If day, month or year are not specified is set to 01 or 0000
	 * @return publishing date.
	 */
	private Date getDateofBook(){
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH + "/work");
		Date date = null;

		for(Node node : nodes){
			Node field = node.selectSingleNode("original_publication_day");
			String day;
			if(!field.getText().isEmpty()){
				day = field.getText();
			}else{
				day = "01";
			}

			field = node.selectSingleNode("original_publication_month");
			String month;
			if(!field.getText().isEmpty()){
				month = field.getText();
			}else{
				month = "01";
			}

			field = node.selectSingleNode("original_publication_year");
			String year;
			if(!field.getText().isEmpty()){
				year = field.getText();
			}else{
				year = "0000";
			}

			String date_temp = year + "-" + month + "-" + day;
			date = Date.valueOf(date_temp);
		}
		return date;
	}

	/**
	 * This method provide Book's average vote from GoodReads.
	 * @return avarage vote.
	 */
	private Double getAvg_vote(){
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH);
		Double avg_vote = null;

		for(Node node : nodes){
			Node field = node.selectSingleNode("average_rating");
			avg_vote = Double.parseDouble(field.getText());
		}
		return avg_vote;
	}

	/**
	 * This method provide the number of pages from GoodReads.
	 * @return Number of pages.
	 */
	private int getNop(){
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH);
		int nop = 0;

		for(Node node : nodes){
			Node field = node.selectSingleNode("num_pages");
			nop = Integer.parseInt(field.getText());
		}
		return nop;
	}

	/**
	 * This method provide the publisher or editor from GoodReads.
	 * @return publisher or editor.
	 */
	private String getPublisher(){
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH);
		String publisher = null;

		for(Node node : nodes){
			Node field = node.selectSingleNode("publisher");
			publisher = field.getText();
		}
		return publisher;
	}

	/**
	 * This method provide book's description from GoodReads.
	 * @return Description.
	 */
	private String getDescription() {
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH);
		String descr = null;

		for(Node node : nodes){
			Node field = node.selectSingleNode("description");
			descr = field.getText();
		}
		return descr;
	}

	/**
	 * This method provide the image's url from GoodReads.
	 * @return image's url.
	 */
	public String getImage_Url(){
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH);
		String image_url = null;

		for(Node node : nodes){
			Node field = node.selectSingleNode("image_url");
			image_url = field.getText();
		}
		return image_url;
	}

	/**
	 * This method provide the small image's url from GoodReads.
	 * @return Small image's url.
	 */
	public String getImage_Url_small(){
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH);
		String image_url_small = null;

		for(Node node : nodes){
			Node field = node.selectSingleNode("small_image_url");
			image_url_small = field.getText();
		}
		return image_url_small;
	}
	
	/**
	 * This  method build a URI for the request to GoodReads
	 * @param code every book's code (ISBN, ISBN13, ASIN)
	 * @return the URL for request
	 */
	protected String buildURL_book_isbn(String code){
		String httpRequest = "http://www.goodreads.com/book/isbn?format=xml&isbn="+code+"&key="+GR_KEY;
		return httpRequest;
	}

	
}
