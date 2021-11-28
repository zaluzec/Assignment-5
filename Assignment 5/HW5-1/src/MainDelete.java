import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {
	public static void delete(int id) {
		SessionFactory factory = new Configuration().configure("hibernate.xml").addAnnotatedClass(Professor.class)
				.addAnnotatedClass(Customer.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Professor professor = new Professor();
			professor.setId(id);
			session.delete(professor);

			Customer customer = new Customer();
			customer.setId(id);
			session.delete(customer);
			session.getTransaction().commit();

			System.out.println("customer/professor has been removed");
		} finally {
			session.close();
			factory.close();

		}

	}
}
