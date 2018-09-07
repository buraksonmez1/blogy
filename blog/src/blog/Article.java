package blog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Article {

	private int id;
	private String text;
	private String author;
	private String date;
	private String title;

	public Article() {

	}

	public Article(String title, String text) {

		this.title = title;
		this.text = text;

		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();

		date = df.format(dateobj);

	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
