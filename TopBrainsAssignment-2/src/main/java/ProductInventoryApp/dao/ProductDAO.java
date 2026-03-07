package ProductInventoryApp.dao;

import ProductInventoryApp.model.Product;
import ProductInventoryApp.util.DBConnection;

import java.sql.*;

public class ProductDAO {

    public void addProduct(Product product) {
        String query = "INSERT INTO products(product_id, product_name, category, price, quantity, rating) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, product.getProductId());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getCategory());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getQuantity());
            ps.setDouble(6, product.getRating());

            ps.executeUpdate();
            System.out.println("Product added successfully!");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: Product ID already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewAllProducts() {
        String query = "SELECT * FROM products";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("product_id") + " " +
                                rs.getString("product_name") + " " +
                                rs.getString("category") + " " +
                                rs.getDouble("price") + " " +
                                rs.getInt("quantity") + " " +
                                rs.getDouble("rating")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewProductById(int id) {
        String query = "SELECT * FROM products WHERE product_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getString("product_name"));
            } else {
                System.out.println("Product not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePrice(int id, double price) {
        String query = "UPDATE products SET price=? WHERE product_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setDouble(1, price);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Price updated successfully.");
            else
                System.out.println("Product not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateQuantity(int id, int qty) {
        String query = "UPDATE products SET quantity=? WHERE product_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, qty);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Quantity updated successfully.");
            else
                System.out.println("Product not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        String query = "DELETE FROM products WHERE product_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Product deleted.");
            else
                System.out.println("Product does not exist.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchByName(String keyword) {
        String query = "SELECT * FROM products WHERE product_name LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("product_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void lowStockProducts() {
        String query = "SELECT * FROM products WHERE quantity < 5";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("product_id") + " " +
                                rs.getString("product_name") + " " +
                                rs.getInt("quantity")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
