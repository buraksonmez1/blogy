package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


import blog.Article;
import blog.Users;
import controller.checkDataBase;

@Component

public class ArticleDAOImp implements ArticleDAO{

	

	
	private DataSource dataSource;
	private NamedParameterJdbcTemplate template;
	
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template=new NamedParameterJdbcTemplate(dataSource);
	}



 //DB'ye article'larý postlayan method.
	@Override
	public void postArticle(Article article) {
		Map<String, Object> params=new HashMap<>();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		
	    String date=df.format(dateobj);
	    
	    article.setDate(date);

	    
		params.put("author",article.getAuthor());
		params.put("text",article.getText());
		params.put("date", article.getDate());
		params.put("title",article.getTitle());
		
		
		
		template.update("insert into article(title,text,author,date) values(:title,:text,:author,:date)", params);
		System.out.println(params.toString());
	}
	
	
	//checkDataBase deki article'larý çaðýran methodu kullanarak bunlarý defaultController'da kullanýlmasýný saðlýyor.
	public List<Article> showArticles() {
		checkDataBase ch=new checkDataBase();
		
		
		return ch.articleList();
	
	}









	
	





	
	
	
	
	
}
