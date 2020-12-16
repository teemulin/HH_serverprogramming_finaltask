package fi.teemuli.Assetlist.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EmployeeEnroll {
	
	@NotEmpty
	@Size(min=3, max=20)
	private String fname = "";
	
	@NotEmpty
	@Size(min=3, max=20)
	private String lname = "";
	
	@NotEmpty
	@Size(min=5, max=30)
	private String email = "";
	
	@NotEmpty
	@Size(min=8, max=10)
	private String phone = "";

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	

}