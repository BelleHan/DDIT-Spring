package com.spring.command;

public class LoginCommand {
	
	private String id="-1";
	private String pwd="-1";
	
	public String getId() {
		return id;
	}
	public void setIddddddddddddd(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		return "LoginCommand [id=" + id + ", pwd=" + pwd + "]";
	}
	
}
