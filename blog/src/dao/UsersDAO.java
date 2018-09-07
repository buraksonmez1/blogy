package dao;



import blog.Users;

public interface UsersDAO {

	public boolean createUser(Users user);
	
	public Users checkLogin(String username,String password);
}
