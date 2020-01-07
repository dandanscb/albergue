package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private Long id;
	 
	public Long getID() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="TITLE")
	private String title;
	@Column(name="NAME")
	private String name;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="BIRTHDAY")
	private LocalDate birthday;
	@ManyToOne
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;
	@Column(name="EMAIL")
	private String email;
	
//	private Set<Reservation> reservations = new HashSet<Reservation>();
	
//    public Customer() {
//    	this(null);
//    }
//    
//    public Customer(String title) {
//    	this(title, "");
//    }
//    public Customer(String title, String name) {
//    	this(title, name, "");
//    }
//    
//    public Customer(String title, String name, String lastName) {
//    	this(title, name, lastName, "");
//    }
//    
//    public Customer(String title, String name, String lastName, String birthday) {
//    	this.title = title;
//    	this.name = name;
//    	this.lastName = lastName;
//    	
//    	if ((birthday != null) && (birthday != "")) {
//    		setBirthday(birthday);
//    	} 
//    }
//    
    public String getTitle() {
    	return title;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

//	public Set<Reservation> getReservations() {
//		return reservations;
//	}
//
//	public void setReservations(Set<Reservation> reservations) {
//		this.reservations = reservations;
//	}
//	
//	public void addReservation(Reservation reservation) {
//		this.reservations.add(reservation);
//	}
	
	
	public void setBirthday(String birthday) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date = LocalDate.parse(birthday, formatter);
			System.out.printf("%s%n", date);
			this.birthday = date;
		} catch (DateTimeParseException d) {
			System.out.printf("%s is not parseable!%n", birthday);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
//	@Override
//	public String toString() {
//		return "Customer [name=" + name + ", lastName=" + lastName + ", birthday=" + birthday + ", address=" + address
//				+ ", email=" + email + ", reservations=" + reservations;
//	}
//	
	
}
