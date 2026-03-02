package batchprocessing.dao;

import batchprocessing.entity.Player;
import batchprocessing.repository.PlayerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {
    @Override
    public void insertBatch(List<Player> players) throws SQLException {
        String sql = "INSERT INTO Players (name,country) VALUES (?,?)";

        try (Connection conn = PlayerRepository.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            for (Player player : players) {
                pst.setString(1,player.getName());
                pst.setString(2,player.getCountry());

                pst.addBatch();
            }

            int[] results = pst.executeBatch();

            conn.close();
            System.out.println("Successfully inserted " + results.length + " players.");

        } catch (Exception e) {
            System.err.println("Batch insert failed; rolling back");
            throw e;
        }

    }

    @Override
    public void updateBatch(List<Player> Players) throws SQLException {
        String sql = "UPDATE Players SET name=?,country=? WHERE id=?";

        try (Connection conn = PlayerRepository.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            for (Player player : Players) {
                pst.setString(1,player.getName());
                pst.setString(2,player.getCountry());
                pst.setInt(3,player.getId());

                pst.addBatch();
            }

            int[] results = pst.executeBatch();

            conn.close();
            System.out.println("Successfully updated.");

        } catch (Exception e) {
            System.err.println("Batch insert failed; rolling back");
            throw e;
        }

    }

    @Override
    public void deleteBatch(List<Integer> PlayerIds) throws SQLException {

    }

    @Override
    public List<Player> fetchAll() throws SQLException {
        return new ArrayList<>();
    }
}
