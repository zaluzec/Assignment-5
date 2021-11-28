import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateOrder {
	public static void createOrder(Product p, String name) {
		SessionFactory factory = new Configuration().
		        configure("hibernate.xml").
		        addAnnotatedClass(Order.class).
		        addAnnotatedClass(Product.class).
		        buildSessionFactory();
	
	
		Session session = factory.getCurrentSession();
		try {
			session = factory.openSession();

			session.beginTransaction();
			session.save(p);
			Order order = new Order(LocalDate.now(), name);
			order.addProductToOrder(p);
			
			session.save(order);
			session.getTransaction().commit();
			
			System.out.println("order containing product created");
		} finally {
			session.close();
			factory.close();
		}
		
	
	}
	
}
