package com.jcpp.droidbook.api.goodReads;
import java.io.IOException;
import java.sql.Date;

import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.jcpp.droidbook.api.APIManager;
import com.jcpp.droidbook.dao.Author;


public class ApiAuthor{

	APIManager apiManager = APIManager.getApiManager();
	GoodReadsManager gr_manager = GoodReadsManager.getManager();
	
	public Author getAuthorById(String id){
		Author author = new Author();

		try {
			GoodReadsManager.setResponse((Response) Jsoup.connect(requestAuthorById(id)).execute());
		} catch (IOException e) {
			e.printStackTrace();
		}
		GoodReadsManager.setBody(GoodReadsManager.getResponse().body());
		GoodReadsManager.setDoc(Jsoup.parse(GoodReadsManager.getBody(), "", Parser.xmlParser()));
		author = compileAuthor(author);

		return author;
	}

	public Author getAuthorByBookCode(String code) {
		Author author = new Author();
		String id = null;
		try {
			GoodReadsManager.setResponse((Response) Jsoup.connect(requestBookByCode(code)).execute());
		} catch (IOException e) {
			e.printStackTrace();
		}
		GoodReadsManager.setBody(GoodReadsManager.getResponse().body());
		GoodReadsManager.setDoc(Jsoup.parse(GoodReadsManager.getBody(), "", Parser.xmlParser()));
		id = GoodReadsManager.getDoc().select("authors").select("author").select("id").get(0).text();
		//
		try {
			GoodReadsManager.setResponse((Response) Jsoup.connect(requestAuthorById(id)).execute());
		} catch (IOException e) {
			e.printStackTrace();
		}
		GoodReadsManager.setBody(GoodReadsManager.getResponse().body());
		GoodReadsManager.setDoc(Jsoup.parse(GoodReadsManager.getBody(), "", Parser.xmlParser()));
		compileAuthor(author);

		return author;
	}

	/**
	 * This method provides the Author's firstname.
	 * @return
	 */
	private String getName(){
		String name_full = null;
		name_full = GoodReadsManager.getDoc().select("name").get(0).text();

		String[] names = name_full.split(" ");
		return names[0];
	}

	/**
	 * This method provides the Author's surname.
	 * @return
	 */
	private String getSurname(){
		String name_full = null;
		name_full = GoodReadsManager.getDoc().select("name").get(0).text();
		String[] names = name_full.split(" ");

		return names[names.length-1];
	}

	/**
	 * This method provides the Author's gender.
	 * @return
	 */
	private String getGender(){
		String gender = null;
		gender = GoodReadsManager.getDoc().select("gender").get(0).text();

		return gender;
	}

	/**
	 * This method provides the Author's born date.
	 * @return
	 */
	private Date getBornDate(){
		Date date = null;
		if(!GoodReadsManager.getDoc().select("born_at").get(0).text().equals("")){
			date = Date.valueOf(GoodReadsManager.getDoc().select("born_at").get(0).text().replace("/", "-"));
		}
		return date;
	}

	/**
	 * This method provides the Author's died date.
	 * @return
	 */
	private Date getDiedDate(){
		Date date = null;
		if(!GoodReadsManager.getDoc().select("died_at").get(0).text().equals("")){
			date = Date.valueOf(GoodReadsManager.getDoc().select("died_at").get(0).text().replace("/", "-"));
		}
		return date;
	}

	/**
	 * This method provides the Author's hometown.
	 * @return
	 */
	private String getHometown(){
		String hometown_full = null;
		hometown_full = GoodReadsManager.getDoc().select("hometown").get(0).text();

		String[] hometown = hometown_full.split(",");
		return hometown[0];
	}

	/**
	 * This method provides the Author's nation.
	 * @return
	 */
	private String getNation(){
		String hometown_full = null;
		hometown_full = GoodReadsManager.getDoc().select("hometown").get(0).text();

		String[] hometown = hometown_full.split(",");
		if(hometown[0].equals(hometown[hometown.length-1])){
			hometown[hometown.length-1] = "n/d";
		}
		return hometown[hometown.length-1];
	}

	/**
	 * This method provides the Author's about or description.
	 * @return
	 */
	private String getDescription(){
		String description = null;
		description = GoodReadsManager.getDoc().select("description").get(0).text();

		return Jsoup.parse(description).text();
	}

	private Author compileAuthor(Author author){
		author.setName(getName());
		author.setSurname(getSurname());
		author.setGender(getGender());
		author.setBorn_date(getBornDate());
		author.setDied_date(getDiedDate());
		author.setHometown(getHometown());
		author.setNation(getNation());
		author.setDescription(getDescription());
		author.build();

		return author;
	}

	/**
	 * This method provides the Author's thumbnail url.
	 * @return
	 */
	public String getThumbnail(Document doc){
		String thumbnail = null;
		thumbnail = GoodReadsManager.getDoc().select("small_image_url").get(0).text();
		return thumbnail;
	}

	/*private List<String> getIdAuthors(){
		List<String> ids = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		List<Node> nodes = GoodReadsManager.doc.selectNodes(BASE_PATH_BOOK + "/authors/author");
		for(Node node : nodes){
			Node field = node.selectSingleNode("id");
			ids.add(field.getText());
		}
		return ids;
	}

	/**
	 * This method builds the httpRequest string to get the author by own id.
	 * @param id_author
	 * @return the string builded.
	 */
	private String requestAuthorById(String id_author){
		String httpRequest = "https://www.goodreads.com/author/show/"+id_author+".xml?key="+apiManager.GR_KEY;
		return httpRequest;
	}

	private String requestBookByCode(String code){
		String httpRequest = "http://www.goodreads.com/book/isbn?format=xml&isbn="+code+"&key="+apiManager.GR_KEY;
		return httpRequest;
	}
}

