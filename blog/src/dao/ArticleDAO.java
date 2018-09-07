package dao;



import java.util.List;

import blog.Article;
import blog.Users;

public interface ArticleDAO {

	
	public void postArticle(Article article);
	public List<Article> showArticles();
	
	

		
	
}
