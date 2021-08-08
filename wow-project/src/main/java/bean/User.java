package bean;



public class User{
	private RoleEnum role;
	private String login;
	
	public User(String login, RoleEnum role) {
		super();
		this.role = role;
		this.login = login;
	}
	public String getRole() {
		return role.toString();
	}
	public void setRole(RoleEnum role) {
		this.role = role;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	

}
