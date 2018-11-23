package org.bft.java8.readcsvfileintolistusingstream;

public class People {
	String firstname;
	String lastname;
	String email;
	int ability;
	String username;
	String password;
	String avatar;

	public People() {
		super();
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param ability
	 * @param username
	 * @param password
	 * @param avatar
	 */
	public People(String firstname, String lastname, String email, int ability, String username, String password,
			String avatar) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.ability = ability;
		this.username = username;
		this.password = password;
		this.avatar = avatar;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the ability
	 */
	public int getAbility() {
		return ability;
	}

	/**
	 * @param ability the ability to set
	 */
	public void setAbility(int ability) {
		this.ability = ability;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "People [username=" + username + ", ability=" + ability + ", email=" + email + "]";
	}
	
	
	
}
