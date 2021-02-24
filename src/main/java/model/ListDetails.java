/**
 * @author ${user} - ejmanning
 * CIS175 - Spring 2021
 * ${date}
 */

package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="LAST_UPDATED")
	private LocalDate lastUpdated;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="OWNER_ID")
	private ShoeOwner shoeOwner;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
			(
				name="shoes_on_list",
				joinColumns= { @JoinColumn(name="LIST_ID", referencedColumnName = "LIST_ID") }, 
				inverseJoinColumns= { @JoinColumn(name="SHOE_ID", referencedColumnName = "ID", unique=true) }
			)
	private List<ShoeItem> listOfShoes;
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, LocalDate lastUpdated, ShoeOwner shoeOwner, List<ShoeItem> listOfShoes) {
		super();
		this.id = id;
		this.listName = listName;
		this.lastUpdated = lastUpdated;
		this.shoeOwner = shoeOwner;
		this.listOfShoes = listOfShoes;
	}
	
	public ListDetails(String listName, LocalDate lastUpdated, ShoeOwner shoeOwner, List<ShoeItem> listOfShoes) {
		super();
		this.listName = listName;
		this.lastUpdated = lastUpdated;
		this.shoeOwner = shoeOwner;
		this.listOfShoes = listOfShoes;
	}
	
	public ListDetails(String listName, LocalDate lastUpdated, ShoeOwner shoeOwner) {
		super();
		this.listName = listName;
		this.lastUpdated = lastUpdated;
		this.shoeOwner = shoeOwner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getLastUpdated() {
		return lastUpdated;
	}

	public void setTripDate(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public ShoeOwner getShoeOwner() {
		return shoeOwner;
	}

	public void setShopper(ShoeOwner shoeOwner) {
		this.shoeOwner = shoeOwner;
	}

	public List<ShoeItem> getListOfShoes() {
		return listOfShoes;
	}

	public void setListOfShoes(List<ShoeItem> listOfShoes) {
		this.listOfShoes = listOfShoes;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", lastUpdated=" + lastUpdated + ", shoeOwner=" + shoeOwner
				+ ", listOfShoes=" + listOfShoes + "]";
	}
	
	
}
