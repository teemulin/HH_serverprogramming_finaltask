package fi.teemuli.Assetlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Asset {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //autogenerate ID by database for each asset
	private Long id;
	
	private String model, brand, serial;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "categoryid")
	private Category category;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "employeeid")
	private Employee employee;
	
	public Asset() {
		
	}
	
	public Asset(String model, String brand, String serial, Category category, Employee employee) {
		super();
		this.model = model;
		this.brand = brand;
		this.serial = serial;
		this.category = category;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", model=" + model + ", brand=" + brand + ", serial=" + serial + ", category="
				+ this.getCategory() + ", employee=" + this.getEmployee() + "]";
	}

	

}
