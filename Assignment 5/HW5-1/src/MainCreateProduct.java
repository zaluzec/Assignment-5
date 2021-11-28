import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateProduct {
	public static void createProduct(String name) {
		SessionFactory factory = new Configuration().configure("hibernate.xml").addAnnotatedClass(Product.class)
				.addAnnotatedClass(Order.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();

			Product product = new Product(name);
			session.save(product);
			session.getTransaction().commit();

			System.out.println("product created");
		} finally {
			session.close();

		}

	}
}
