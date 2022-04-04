package com.model;

public class User{

private String name;
private String username;
private String password;
private String email;
private Long contact;
//User model can access the attributes of the Complaint model which is referred in DAO class
private Complaint complaint;

//@Override
//public String toString() {
	//return "User [name=" + name + ", username=" + username + ", password=" + password + ", email=" + email
			//+ ", contact=" + contact + ", complaint=" + complaint + "]";
//}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getContact() {
	return contact;
}
public void setContact(Long contact) {
	this.contact = contact;
}
public Complaint getComplaint() {
	return complaint;
}
public void setComplaint(Complaint complaint) {
	this.complaint = complaint;
}

}