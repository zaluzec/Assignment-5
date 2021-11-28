import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HibernateOperations {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		resetDB();// reset database to initial state

		MainCreate.create(); // adds with generated id of 1

		// set this to next index of generated IDs
		// this value will be 1 on a newly created database
		MainDelete.delete(1); // deletes the customer/professor just added

		MainCreateProduct.createProduct("product0");// add product with id of 1

		// add order with id of 1,
		// and product with id of 2

		MainCreateOrder.createOrder(new Product("product1"), "customer1");
		MainDeleteOrder.deleteOrder(1); // delete order with id 1

		MainDeleteProduct.deleteProduct(1); // delete product with id 1

		MainDeleteProduct.deleteProduct(2); // delete product with id 2 (that was added with order)

	}

	public static void resetDB() throws ClassNotFoundException, SQLException {
		String URL = "jdbc:postgresql://localhost:5432/Question1";
		String USER = "postgres";
		String PWD = "123";

		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(URL, USER, PWD);

		PreparedStatement stmt = connection
				.prepareStatement("TRUNCATE customer, professor, order_1, product, order_detail;");

		stmt.execute();

		stmt = connection.prepareStatement("ALTER SEQUENCE customer_id_seq RESTART WITH 1");

		stmt.execute();

		stmt = connection.prepareStatement("ALTER SEQUENCE professor_id_seq RESTART WITH 1");

		stmt.execute();

		stmt = connection.prepareStatement("ALTER SEQUENCE order_id_seq RESTART WITH 1");

		stmt.execute();

		stmt = connection.prepareStatement("ALTER SEQUENCE product_id_seq RESTART WITH 1");

		stmt.execute();

	}

}
