package com.zbxh.swsrv.entity;

/**
 * 用户注册表
 * @author Administrator
 * 2018-11-1
 * 李坤
 *
 */
public class User {
	
	private int userID;
	
	private String department;
	
	private String username; 
	
	private String password;
	
	private String isdelete;
	
	private String email;
	
	private String power;
	
	private String tel;
	
	private String iseidt;

	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(int userID, String department, String username, String password, String isdelete, String email,
			String power, String tel, String iseidt) {
		super();
		this.userID = userID;
		this.department = department;
		this.username = username;
		this.password = password;
		this.isdelete = isdelete;
		this.email = email;
		this.power = power;
		this.tel = tel;
		this.iseidt = iseidt;
	}

	
	public int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
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



	public String getIsdelete() {
		return isdelete;
	}



	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPower() {
		return power;
	}



	public void setPower(String power) {
		this.power = power;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getIseidt() {
		return iseidt;
	}



	public void setIseidt(String iseidt) {
		this.iseidt = iseidt;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "User [userID=" + userID + ", department=" + department + ", username=" + username + ", password="
				+ password + ", isdelete=" + isdelete + ", email=" + email + ", power=" + power + ", tel=" + tel
				+ ", iseidt=" + iseidt + "]";
	}

	
	
	

}
