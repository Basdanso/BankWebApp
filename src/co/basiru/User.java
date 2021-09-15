package co.basiru;

import java.util.Set;

public class User {
	private int id;
	private String username;
	private String password;
	private Set<AccountDetails> AccountDetails;
	
	public User() {
		System.out.println("inside 0 arg construcyor");
		
	}

	public User(int id, String username, String password) {
		super();
		System.out.println("inside param constru");
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		System.out.println("inside getter method");
		return id;
	}

	public void setId(int id) {
		System.out.println("inside setter method");
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Set<AccountDetails> getAccountDetails() {
		return AccountDetails;
	}

	public void setAccountDetails(Set<AccountDetails> accountDetails) {
		AccountDetails = accountDetails;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	


}
