package DAO;

import java.sql.SQLException;

public class SalaryDao {
    private final DatabaseSession db;

    public SalaryDao(DatabaseSession db) {
        this.db = db;
    }

    public void update(String id, String salary) throws SQLException {
        String sql = "update employee set emp_id = '" + id + "',Salary = '"
                + salary + "'where emp_id = '" + id + "'   ";
        db.ps = db.con.prepareStatement(sql);
        db.ps.execute();
    }
}
