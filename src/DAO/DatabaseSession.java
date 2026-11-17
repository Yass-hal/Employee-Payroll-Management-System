package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSession {
    final Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement stm;

    public DatabaseSession() {
        con = DatabaseHelper.getConnection();
    }

    public void closeResults() throws SQLException {
        rs.close();
        ps.close();
    }
}
