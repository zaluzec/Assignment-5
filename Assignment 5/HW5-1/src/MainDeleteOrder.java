import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteOrder {

	public static void deleteOrder(int id) {

		SessionFactory factory = new Configuration().configure("hibernate.xml").addAnnotatedClass(Order.class)
				.addAnnotatedClass(Product.class).

				buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Order order = new Order();
			order.setId(id);
			session.delete(order);
			session.getTransaction().commit();

			System.out.println("deleted order");
		} finally {
			session.close();
			factory.close();
		}

	}

}
