package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {
	
	@Id
	@Column(name="ADDRESS_ID")
	private Long addressID;
	
	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	@Column(name="ADDRESS")
	private String address;
	@Column(name="ZIPCODE")
	private String zipCode;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	@Column(name="COUNTRY")
	private String country;
	
	
//	public Address() {
//		 
//	}
//
//	public Address(String address, String zipCode, String city, String state, String country) {
//		this.address = address;
//		this.zipCode = zipCode;
//		this.city = city;
//		this.state = state;
//		this.country = country;
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", zipCode=" + zipCode + ", city=" + city + ", state=" + state
				+ ", country=" + country + "]";
	}
}
