package com.ssp.bean;

import java.util.Date;

public class Resume {
	private int uid;
	private String realName;
	private String gender;
	private Date birthday;
	private String location;
	private String telephone;
	private String email;
	private String headPic;
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	public Resume() {
		super();
	}
	@Override
	public String toString() {
		return "Resume [uid=" + uid + ", realName=" + realName + ", gender=" + gender + ", birthday=" + birthday
				+ ", location=" + location + ", telephone=" + telephone + ", email=" + email + ", headPic=" + headPic
				+ "]";
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Resume(int uid, String realName, String gender, Date birthday, String location, String telephone,
			String email, String headPic) {
		super();
		this.uid = uid;
		this.realName = realName;
		this.gender = gender;
		this.birthday = birthday;
		this.location = location;
		this.telephone = telephone;
		this.email = email;
		this.headPic = headPic;
	}
	
	public Resume(int uid, String realName, String gender, Date birthday, String location, String telephone,
			String email) {
		super();
		this.uid = uid;
		this.realName = realName;
		this.gender = gender;
		this.birthday = birthday;
		this.location = location;
		this.telephone = telephone;
		this.email = email;
	}
	
	
	
}
