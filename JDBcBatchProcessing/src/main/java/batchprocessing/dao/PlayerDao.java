package batchprocessing.dao;

import batchprocessing.entity.Player;

import java.sql.SQLException;
import java.util.List;

public interface PlayerDao {
    void insertBatch(List<Player> Players) throws SQLException;
    void updateBatch(List<Player> Players) throws SQLException;
    void deleteBatch(List<Integer> PlayerIds) throws SQLException;

    List<Player> fetchAll() throws SQLException;
}
