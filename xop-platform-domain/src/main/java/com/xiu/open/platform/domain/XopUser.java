package com.xiu.open.platform.domain;

public class XopUser extends BaseDomain {

	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private int age;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
