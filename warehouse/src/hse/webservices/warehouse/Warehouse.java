package hse.webservices.warehouse;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.jws.WebService;

@WebService
public class Warehouse {
	
	// Returns the amount of all available product types
	int getProductTypesCount() throws IOException {
		ConnectionDB conn = null;
		int productCount = 0;
		try {
			conn = new ConnectionDB("root", "manager");
			String query = "SELECT COUNT(*) FROM product;";
			ResultSet result = conn.queryDB(query);
			if (result.next()) {
				productCount = result.getInt(1);
			}
		} catch (Exception e) {
			throw new IOException("gettingProductTypesCount exception");
		} finally {
			conn.disconnectDB();
		}
		return productCount;
	}

	// Gets all available products
	Product[] getAllProducts() throws IOException
	{
		return getProductRange(1, getProductTypesCount());
	}

	// Gets all available products from "first" to "last";
	Product[] getProductRange(int first, int last) throws IOException {
		ArrayList<Product> products = new ArrayList<Product>();
		Product product;
		ConnectionDB conn = null;
		try {
			conn = new ConnectionDB("root", "manager");
			String query = "SELECT * FROM product WHERE id <= " + first
			+ " AND id >= " + last + ";";
			ResultSet result = conn.queryDB(query);
			while (result.next()) {
				product = new Product(result.getString(2), result.getDouble(3), result.getInt(4));
				products.add(product);
			}
		} catch (Exception e) {
			throw new IOException("gettingProductTypesCount exception");
		} finally {
			conn.disconnectDB();
		}
		Product[] res = new Product[getProductTypesCount()];
		products.toArray(res);
		return res;
	}
}
