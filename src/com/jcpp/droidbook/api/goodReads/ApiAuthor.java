package com.jcpp.droidbook.api.goodReads;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.jsoup.Jsoup;

import com.jcpp.droidbook.dao.Author;


public class ApiAuthor extends GoodReadsManager{

	private final String BASE_PATH_BOOK = "//GoodreadsResponse/book";
	private final String BASE_PATH_AUTHOR = "//GoodreadsResponse/author";

	@Override
	public Author getAuthorById(String id_author) throws DocumentException{
		Author author = new Author();

		// Get the SAXReader object
		SAXReader reader = new SAXReader();
		doc = reader.read(requestAuthorById(id_author));
		if(/*condizione di controllo*/ null == null){
			author = compileAuthor(author);
		}

		return author;
	}

	@Override
	public List<Author> getAuthorByCode(String code) throws DocumentException{
		List<Author> authors = new ArrayList<Author>();
		List<String> ids = new ArrayList<String>();

		// Get the SAXReader object
		SAXReader reader = new SAXReader();
		doc = reader.read(requestBookByCode(code));
		ids = getIdAuthors();
		for(String id : ids){
			doc = reader.read(requestAuthorById(id));
			Author auth = new Author();
			auth = compileAuthor(auth);
			authors.add(auth);	
		}
		return authors;
	}

	/**
	 * This method provides the Author's firstname.
	 * @return
	 */
	private String getName(){
		String name_full = null;
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH_AUTHOR);

		for(Node node : nodes){
			Node field = node.selectSingleNode("name");
			name_full = field.getText();
		}

		String[] names = name_full.split(" ");
		return names[0];
	}

	/**
	 * This method provides the Author's surname.
	 * @return
	 */
	private String getSurname(){
		String name_full = null;
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH_AUTHOR);

		for(Node node : nodes){
			Node field = node.selectSingleNode("name");
			name_full = field.getText();
		}

		String[] names = name_full.split(" ");
		return names[names.length-1];
	}

	/**
	 * This method provides the Author's gender.
	 * @return
	 */
	private String getGender(){
		String gender = null;
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH_AUTHOR);

		for(Node node : nodes){
			Node field = node.selectSingleNode("gender");
			gender = field.getText();
		}

		return gender;
	}

	/**
	 * This method provides the Author's born date.
	 * @return
	 */
	private Date getBornDate(){
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH_AUTHOR);
		Date date = null;
		for(Node node : nodes){
			Node field = node.selectSingleNode("born_at");
			if(!field.getText().equals("")){
				date = Date.valueOf(field.getText().replace("/", "-"));
			}
		}
		return date;
	}

	/**
	 * This method provides the Author's died date.
	 * @return
	 */
	private Date getDiedDate(){
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH_AUTHOR);
		Date date = null;
		for(Node node : nodes){
			Node field = node.selectSingleNode("died_at");
			if(!field.getText().equals("")){
				date = Date.valueOf(field.getText().replace("/", "-"));
			}
		}
		return date;
	}

	/**
	 * This method provides the Author's hometown.
	 * @return
	 */
	private String getHometown(){
		String hometown_full = null;
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH_AUTHOR);

		for(Node node : nodes){
			Node field = node.selectSingleNode("hometown");
			hometown_full = field.getText();
		}

		String[] hometown = hometown_full.split(",");
		return hometown[0];
	}

	/**
	 * This method provides the Author's nation.
	 * @return
	 */
	private String getNation(){
		String hometown_full = null;
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH_AUTHOR);

		for(Node node : nodes){
			Node field = node.selectSingleNode("hometown");
			hometown_full = field.getText();
		}
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
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH_AUTHOR);

		for(Node node : nodes){
			Node field = node.selectSingleNode("about");
			description = field.getText();
		}

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
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH_AUTHOR);

		for(Node node : nodes){
			Node field = node.selectSingleNode("small_image_url");
			thumbnail = field.getText();
		}
		return thumbnail;
	}

	private List<String> getIdAuthors(){
		List<String> ids = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		List<Node> nodes = doc.selectNodes(BASE_PATH_BOOK + "/authors/author");
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
		String httpRequest = "https://www.goodreads.com/author/show/"+id_author+".xml?key="+GR_KEY;
		return httpRequest;
	}

	private String requestBookByCode(String code){
		String httpRequest = "http://www.goodreads.com/book/isbn?format=xml&isbn="+code+"&key="+GR_KEY;
		return httpRequest;
	}
}

