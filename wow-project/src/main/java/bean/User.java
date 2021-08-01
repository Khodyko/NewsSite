package bean;

public class User extends SqlSendable {
	private String role;
	private String login;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return login;
	}
	public void setPassword(String login) {
		this.login = login;
	}
	
	
	

}
