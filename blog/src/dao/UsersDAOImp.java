package dao;

import java.util.HashMap;

import java.util.Map;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import blog.Users;
import controller.checkDataBase;

@Repository("dao")
public class UsersDAOImp implements UsersDAO {

	private DataSource dataSource;
	private NamedParameterJdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template = new NamedParameterJdbcTemplate(dataSource);

	}

	//Kullanýcýyý register eden DB'ye onu kayýt eden method.
	@Override
	public boolean createUser(Users user) {
		boolean flag = false;
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		checkDataBase ch = new checkDataBase();
		Map<String, Object> params = new HashMap<>();
		params.put("username", user.getUsername());
		params.put("email", user.getEmail());
		params.put("password", user.getPassword());
		params.put("enabled", user.isEnabled());
		params.put("authority", user.getAuthority());

		if (ch.checkPasswords(user) == true && ch.checkRows(user) == false) {

			template.update(
					"insert into users(username,email,password,enabled) values (:username,:email,:password,:enabled)",
					params);
			template.update("insert into authorities(username,authority) values (:username,:authority)", params);

			flag = true;

		}

		return flag;
	}
	
	//kullanýcýný exsist olup olmadýðýný kontrol eden method.
	 public Users checkLogin(String username,String password) {
		 checkDataBase ch =new checkDataBase();

			   return ch.checkDB(username, password);
		   
	 
	 }
	
	 

}
