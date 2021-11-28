import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreate {
	public static void create() {
		SessionFactory factory = new Configuration().configure("hibernate.xml").addAnnotatedClass(Professor.class)
				.addAnnotatedClass(Customer.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Professor professor = new Professor("srthsfrg", "w34e5hus");

			Customer customer = new Customer("srthfbv", "srethe345r");

			professor.setCustomer(customer);
			customer.setProfessor(professor);
			// session.save(customer);
			session.save(professor);
			session.getTransaction().commit();

			System.out.println("customer/professor has been added");
		} finally {
			session.close();
		}

	}

}
