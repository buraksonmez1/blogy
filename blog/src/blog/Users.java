package blog;



public class Users {
 
	  private String username;
	  private String email;
	  private String password;	 
	  private String confirmPassword;
	  private String authority;
	  private boolean enabled=false;
	
	  
	  
	  
	  
	  
	  public Users() {
		
	}
	  




	public Users(String username, String email, String password, String confirmPassword, String authority) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.authority = authority;
	}





	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getConfirmPassword() {
		return confirmPassword;
	}




	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}




	public String getAuthority() {
		return authority;
	}




	public void setAuthority(String authority) {
		this.authority = authority;
	}




	public boolean isEnabled() {
		return enabled;
	}




	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}





	




	@Override
	public String toString() {
		return "Users [username=" + username + ", email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", authority=" + authority + ", enabled=" + enabled + "]";
	}

  



	
	  
	  
	  
	 
	 
}
