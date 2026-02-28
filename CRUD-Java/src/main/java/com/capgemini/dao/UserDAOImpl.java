package com.capgemini.dao;

import com.capgemini.entity.User;
import com.capgemini.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    public void insertUser(User user){
        String sql = "INSERT INTO users(name, email) VALUES(?, ?)";

        try(Connection conn = UserRepository.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());

            pstmt.executeUpdate();
            System.out.println("Player inserted");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateUser(User user){
        String sql = "UPDATE users SET name=?, email=? WHERE id=?";

        try(Connection conn = UserRepository.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setInt(3, user.getId());

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {

        String sql = "DELETE FROM users WHERE id=?";

        try (Connection conn = UserRepository.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = UserRepository.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}
