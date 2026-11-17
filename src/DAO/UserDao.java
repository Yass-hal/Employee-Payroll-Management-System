package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDao {
    private final DatabaseSession db;

    public UserDao(DatabaseSession db) {
        this.db = db;
    }

    public List<User> findUsers(String username, String password, String division) throws SQLException {
        String sql = "select id, username, password, division from Users where (username=? and password =? and division =?)";
        db.ps = db.con.prepareStatement(sql);
        db.ps.setString(1, username);
        db.ps.setString(2, password);
        db.ps.setString(3, division);
        db.rs = db.ps.executeQuery();
        List<User> users = new ArrayList<User>();
        while (db.rs.next()) {
            users.add(new User(db.rs.getInt(1), db.rs.getString("userName")));
        }
        return users;
    }
}
