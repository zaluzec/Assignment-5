import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteProduct {
	public static void deleteProduct(int id) {
		SessionFactory factory = new Configuration().configure("hibernate.xml").addAnnotatedClass(Product.class)
				.addAnnotatedClass(Order.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Product product = new Product();
			product.setId(id);
			session.delete(product);
			session.getTransaction().commit();

			System.out.println("deleted product");
		} finally {
			session.close();
			factory.close();
		}

	}
}