package bean;

import javax.management.relation.Role;

public class User extends SqlSendable {
	private Role role;
	private String login;
	public String getRole() {
		return role.toString();
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	

}
