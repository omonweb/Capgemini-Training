package batchprocessing.repository;

import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlayerRepository {

    public static @Nullable Connection getConnection() throws SQLException {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbcrud",
                    "root",
                    "root"
            );
    }
}
