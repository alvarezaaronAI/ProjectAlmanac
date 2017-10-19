package models;

import java.math.BigInteger;
import java.nio.charset.Charset;

public class User {

	private BigInteger identity;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	/*
	 * Constructor
	 */
	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		identity = uniqueIden();
	}
	
	/*
	 * Creating Method that gives me a unique identity based on the user's information
	 * We create this given the user's last name and email.
	 */
	protected BigInteger uniqueIden() { // protected for testing purposes
		BigInteger lastname = getNumberId(this.lastName);
		BigInteger email = getNumberId(this.email);
		BigInteger uniqueKey = lastname.add(email);
		return uniqueKey;
	}
	
	/*
	 * Returns a big integer that was converted from a string into a a big integer.
	 */
	public static BigInteger getNumberId(String value) {
	    return new BigInteger(value.getBytes(Charset.availableCharsets().get("UTF-8")));
	}
	
	/*
	 * Accessors
	 */
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public BigInteger getIdentity() {
		return identity;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	/*
	 * Mutators
	 */
	
	public void setIdentity(BigInteger identity) {
		this.identity = identity;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return getFullName() + " | Email: " + email + " | Unique identity: " + identity;
	}
}
