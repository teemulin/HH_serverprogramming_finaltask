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
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //autogenerate ID by database for each category
	private Long categoryid;
	
	private String name;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="category")
	private List<Asset> assets;
	
	public Category() {
		
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}

}
