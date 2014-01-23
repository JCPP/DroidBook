package com.jcpp.droidbook.api.goodReads;

import java.io.IOException;
import java.sql.Date;

import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection.Response;
import org.jsoup.parser.Parser;

import com.jcpp.droidbook.api.APIManager;
import com.jcpp.droidbook.dao.Book;

public class ApiBook{
	APIManager apiManager = APIManager.getApiManager();
	GoodReadsManager gr_manager = GoodReadsManager.getManager();
	
	/**
	 * This method provides the book builded, ready to be insert into database.
	 * @param code Isbn, isbn13 or Asin.
	 * @return Book builded.
	 * @throws IOException 
	 */
	public Book getBookByCode(String code) throws IOException{
		Book book = new Book();
		GoodReadsManager.setResponse((Response) Jsoup.connect(buildURL_book_isbn(code)).execute());
		GoodReadsManager.setBody(GoodReadsManager.getResponse().body());
		GoodReadsManager.setDoc(Jsoup.parse(GoodReadsManager.getBody(), "", Parser.xmlParser()));
		
		/*condizione per cui si può evitare di fare tutti i metodi a vuoto*/
		if(null == null){
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
		String isbn = null;
		isbn = GoodReadsManager.getDoc().select("isbn").get(0).text();
		return isbn;
	}

	/**
	 * This method provide Isbn13 from GoodReads.
	 * @return isbn13 code.
	 */
	private String getIsbn13() {
		String isbn13 = null;
		isbn13 = GoodReadsManager.getDoc().select("isbn13").get(0).text();
		return isbn13;
	}

	/**
	 * This method provide Asin from GoodReads.
	 * @return asin code.
	 */
	private String getAsin() {
		String asin = null;
		asin = GoodReadsManager.getDoc().select("asin").get(0).text();
		return asin;
	}

	/**
	 * This method provide title from GoodReads.
	 * @return Book's title.
	 */
	private String getTitle(){
		String title = null;
		title = GoodReadsManager.getDoc().select("title").get(0).text();
		return title;
	}

	/**
	 * This method provide date of book from GoodReads. If day, month or year are not specified is set to 01 or 0000
	 * @return publishing date.
	 */
	private Date getDateofBook(){
		String day = null;
		String month = null;
		String year = null;
		Date date = null;
		
		day = GoodReadsManager.getDoc().select("original_publication_day").get(0).text();
		month = GoodReadsManager.getDoc().select("original_publication_month").get(0).text();
		year = GoodReadsManager.getDoc().select("original_publication_year").get(0).text();
		
		if(day.isEmpty())
			day = "01";
		if(month.isEmpty())
			month = "01";
		if(year.isEmpty())
			year = "0000";
		
		String dateString = year + "-" + month + "-" + day;
		date = Date.valueOf(dateString);
		
		return date;
	}

	/**
	 * This method provide Book's average vote from GoodReads.
	 * @return avarage vote.
	 */
	private Double getAvg_vote(){
		Double avg_vote = null;
		avg_vote = Double.parseDouble(GoodReadsManager.getDoc().select("average_rating").get(0).text());
		
		return avg_vote;
	}

	/**
	 * This method provide the number of pages from GoodReads.
	 * @return Number of pages.
	 */
	private int getNop(){
		int nop = 0;
		nop = Integer.parseInt(GoodReadsManager.getDoc().select("num_pages").get(0).text());
		
		return nop;
	}

	/**
	 * This method provide the publisher or editor from GoodReads.
	 * @return publisher or editor.
	 */
	private String getPublisher(){
		String publisher = null;
		publisher = GoodReadsManager.getDoc().select("publisher").get(0).text();
		
		return publisher;
	}

	/**
	 * This method provide book's description from GoodReads.
	 * @return Description.
	 */
	private String getDescription() {
		String description = null;
		description = GoodReadsManager.getDoc().select("description").get(0).text();
		
		return description;
	}

	/**
	 * This method provide the image's url from GoodReads.
	 * @return image's url.
	 */
	public String getImage_Url(){
		String image_url = null;
		image_url = GoodReadsManager.getDoc().select("image_url").get(0).text();
		
		return image_url;
	}
	
	/**
	 * This method provide the small image's url from GoodReads.
	 * @return Small image's url.
	 */
	public String getImage_Url_small(){
		String image_url = null;
		image_url = GoodReadsManager.getDoc().select("small_image_url").get(0).text();
		
		return image_url;
	}
	
	/**
	 * This  method build a URI for the request to GoodReads
	 * @param code every book's code (ISBN, ISBN13, ASIN)
	 * @return the URL for request
	 */
	protected String buildURL_book_isbn(String code){
		String httpRequest = "http://www.goodreads.com/book/isbn?format=xml&isbn="+code+"&key="+ apiManager.GR_KEY;
		return httpRequest;
	}

	
}
