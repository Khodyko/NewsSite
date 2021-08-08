package bean;



public class RegistrationInfo {
	private String login;
	private String password;
	private RoleEn role;
	
	public void setRole(RoleEn role) {
		this.role = role;
	}
	public RoleEn getRole() {
		return role;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RegistrationInfo(String login, String password, RoleEn role) {
		super();
		this.login = login;
		this.password = password;
		this.role=role;
	}
	
	
}
