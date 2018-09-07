package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import blog.Article;
import blog.Users;
import dao.ArticleDAO;
import dao.UsersDAO;

@Controller
public class DefaultController {

	@Autowired
	private UsersDAO usersDAO;
	
	private String authorName;

	@Autowired
	private ArticleDAO articleDAO;


	
	@RequestMapping("/login")
	public String ShowLoginPage() {

		return "login";
	}

	@RequestMapping("/register")
	public String showRegisterPage() {
		return "register";
	}

	@RequestMapping("/createaccount")
	public String createAccount(Users user,ModelMap modelMap) {

		if (usersDAO.createUser(user) == false) {
			modelMap.put("error","User already exsist please try again");
			return "register";

		} else {
			
			return "login";

		}

	}

	@RequestMapping("/accesslogin")
	public ModelAndView showLoginHomepage(@RequestParam("username") String username,
			@RequestParam("password") String password,ModelMap map) {
		ModelAndView modelAndView = new ModelAndView();
		
		Map<String,String> loginMap = new HashMap<>();
		authorName=username;
		loginMap.put("user",username);
		map.addAllAttributes(loginMap);
		
	 System.out.println("you:"+username);
	 
	 
		 
		if ((usersDAO.checkLogin(username, password)) == null) {
			modelAndView.setViewName("login");
			map.put("error","Wrong user name or password! Please try again!");
			return modelAndView;
		} else {

			modelAndView.addObject("list", articleDAO.showArticles());
			modelAndView.setViewName("home");
			return modelAndView;
		}
	}

	@RequestMapping("/")
	public String showLogout() {
       
		return "home";
	}

	@RequestMapping("/postArticle")
	public ModelAndView postArticle(Article article) {
		ModelAndView modelAndView = new ModelAndView();
		
		article.setAuthor(authorName);
		articleDAO.postArticle(article);
		modelAndView.addObject("list", articleDAO.showArticles());
		modelAndView.setViewName("home");
		return modelAndView;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showArticle(ModelMap map) {

		Map<String, Object> articleMap = new HashMap<>();

		articleMap.put("list", articleDAO.showArticles());

		map.addAllAttributes(articleMap);

		return "home";

	}
	

}
