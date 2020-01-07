package domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Set;

import domain.exceptions.CustomerNotFoundException;
import domain.exceptions.ReservationNotFoundException;
import domain.exceptions.RoomNotFoundException;



public class Hostel {
	
	private String name;
	private Address address = new Address();
	private String phone;
	private static Hostel hostel = new Hostel();
	
	private Set<Reservation>reservations;	
	private Set<Customer> customers;
	private Set<Room> rooms;
		
	private Hostel() { // Creator - Hostel aggregates reservations, customers and rooms
		reservations = new HashSet<>();
		customers = new HashSet<>();
		rooms = new HashSet<>();
	}
	
	public  static Hostel getHostel() {
		return hostel;
	}
	
	public boolean createCustomer(String title, String name, String lastName, String dateOfBirth, String address, String zipCode, String city, String state, 
			                                                   String country, String email) {
		
		if ((title == null) || (name == null) || (lastName == null) || (dateOfBirth == null) || 
			      (address == null) ||  (zipCode == null) || (city == null) || 
			      (state == null) || (country == null) || (email == null)) {
			     return false;
		}
		
		if (name.length() < 3)
			return false;
		
// 		Customer customer = new Customer(title, name, lastName, dateOfBirth);
//		customer.setEmail(email);
 
//		Address tempAddress = new Address(address, zipCode, city,state, country);
//		customer.setAddress(tempAddress);
//		customers.add(customer);	
		
		return true;
	}
	
	public boolean makeReservation(Customer customer, String rsDate, String checkin, String checkout) { 
		Reservation reservation = new Reservation();
		LocalDate checkinDate = null;
		LocalDate checkoutDate = null;
		
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			checkinDate = LocalDate.parse(checkin, formatter);
			checkoutDate = LocalDate.parse(checkout, formatter);
			System.out.printf("%s%n", checkinDate);
			System.out.printf("%s%n", checkoutDate);

 		} catch (DateTimeParseException d) {
			System.out.printf(d.getMessage());
		}
 		
 		reservation.setCheckinDate(checkinDate);
		reservation.setCheckoutDate(checkoutDate);
		
//		customer.addReservation(reservation);
		reservations.add(reservation);
		return true   ;
	}
	
	public boolean makePayment(double amountTendered, String typeOfPayment) {
		return false;
	}
	
	public boolean createRoom(int number, double dimension) {
		Room room = new Room( );
		room.setNumber(number);
		room.setDimension(dimension);
		addRoom(room);
		return true;
	}
	
	public void addRoom(Room room ) {
		rooms.add(room);
	}
	
	public Set<Room> getRooms( ) {
		return rooms;
	}
	
	// TODO Search for rooms by status (available, not available, etc) 
	public Room searchRoomByNumber(int number) throws RoomNotFoundException {
		for (Room room: rooms) {
			if (room.getNumber() == number)
				return room;
		}
		throw new RoomNotFoundException("Room not found !", number);
	}
	
	public Customer searchCustomerByName(String name, String lastName) throws CustomerNotFoundException {
		for (Customer customer: customers) {
			if (customer.getName().equals(name) && customer.getLastName().contains(lastName)){
				return customer;
	    	}
	    }
		throw new CustomerNotFoundException("Customer not found !", name, lastName);
	}	
	
	public Customer searchReservationByCustomerName(String name, String lastName) throws ReservationNotFoundException {
		
		for (Customer customer: customers) {
			if (customer.getName().equals(name) && customer.getLastName().contains(lastName)){
				return customer;
	    	}
	    }
		throw new ReservationNotFoundException("Customer not found !", name, lastName);
	}	
	
//	public Set<Reservation> searchReservations(String name, String lastName) {
//		Customer customer = null;
//		try {
//			customer = searchCustomerByName(name, lastName);		
//
//		} catch(CustomerNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//        return customer.getReservations();
//
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
