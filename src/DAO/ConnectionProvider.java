package DAO;

import java.sql.Connection;
import java.sql.SQLException;
//Interface how database code requests a connection
public interface ConnectionProvider {
    
    Connection openConnection() throws SQLException;
}
