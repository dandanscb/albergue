package domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager em = factory.createEntityManager();
		
		Customer c1 = new Customer();
		c1.setId(1l);
		c1.setEmail("suasau");
		c1.setName("sjsjsjsj");
		Address add = new Address();
		add.setAddressID(2L);
		add.setAddress("ruaaaaaaaaa");
		add.setCity("cidade");
		add.setCountry("country");
		add.setState("estado");
		add.setZipCode("123");
		em.getTransaction().begin();
		em.merge(add);
		em.getTransaction().commit();
		c1.setAddress(add);

		em.getTransaction().begin();
		em.merge(c1);
		em.getTransaction().commit();
	}
}
