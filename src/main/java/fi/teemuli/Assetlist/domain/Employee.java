package fi.teemuli.Assetlist.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //autogenerate ID by database for each employee
	private Long employeeid;
	
	private String fname, lname, email, phone;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="employee")
	private List<Asset> assets2;
	
	public Employee () {
		
	}

	public Employee(String fname, String lname, String email, String phone) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
	}

	public Long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Long employeeid) {
		this.employeeid = employeeid;
	}

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

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", phone=" + phone + "]";
	}

}
