package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import blog.Article;
import blog.Users;
import dao.UsersDAO;

public class checkDataBase {

	//kullanýcý üye olurken username ve emaili kontrol eder.
	
	public boolean checkRows(Users user) {
		boolean flag = true;

		try {

			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/blog", "root", "");
			Statement stmt = con.createStatement();

			String SQL = "SELECT username,email FROM users WHERE  username='" + user.getUsername() + " ' OR  email='"
					+ user.getEmail() + "'";

			ResultSet rs = stmt.executeQuery(SQL);

			if (rs.next()) {
				System.out.println("Failure! Already exisis");
				flag = true;
				System.out.println("rs next:" + flag);
			} else {
				System.out.println("there is not exsist. ");
				flag = false;
			}
			stmt.close();

		} catch (Exception e) {

			System.out.println("ERROR");
		}

		return flag;
	}
//kullanýcý üye olurken girilen confirmpassword'u ve password'u kontrol eder.
	public boolean checkPasswords(Users user) {

		if (user.getConfirmPassword().equals(user.getPassword()))
			return true;

		else
			return false;
	}
	
	//kullanýcý login olurken bilgilerini kontrol eder.
	public Users checkDB(String username,String password) {
		
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/blog", "root", "");
			Statement stmt = con.createStatement();

			String SQL = "SELECT * FROM users WHERE binary username='"+username+"' AND binary password='"
			 +password +"'";

			ResultSet rs = stmt.executeQuery(SQL);
			
			
			if (rs.next()) {
				System.out.println("you can access");
				
				Users currentUser=new Users();
			
				currentUser.setUsername(rs.getString("username"));
				currentUser.setPassword(rs.getString("password"));
				currentUser.setEmail(rs.getString("email"));
				currentUser.setAuthority("ROLE_USER");
				
				
				System.out.println("rs next:" + currentUser.getUsername());
			    return currentUser;
				
			} else {
				System.out.println("you can not access ");
				return null;
			}
			

		} catch (Exception e) {

			System.out.println("ERROR");
		 return null;
		}

		
	}

	//DB'de ki article'larý  çaðýrýr.
	public List<Article> articleList() {
		
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/blog", "root", "");
			Statement stmt = con.createStatement();
           
			
			String SQL = "select * from blog.article order by idarticle desc ";
					
			
			ResultSet rs = stmt.executeQuery(SQL);

			List<Article> articleList = new ArrayList<>();
			
			while(rs.next()) {
				
			 Article article =new Article();
			 
			article.setAuthor(rs.getString("author"));
			article.setTitle(rs.getString("title"));
			article.setText((rs.getString("text")));
			article.setDate(rs.getString("date"));
			article.setId(rs.getInt("idarticle"));
			
			articleList.add(article);
		}
			
			stmt.close();
		return articleList;
	
}catch (Exception e) {

	System.out.println("ERROR");
}
		return null;
}
	
	
	
	
}