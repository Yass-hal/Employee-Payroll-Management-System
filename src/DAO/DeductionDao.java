package DAO;

import java.sql.SQLException;
import model.DeductionData;

public class DeductionDao {
    private final DatabaseSession db;

    public DeductionDao(DatabaseSession db) {
        this.db = db;
    }

    public void save(DeductionData deduction) throws SQLException {
        String sql = "insert into deduction"
                + "(emp_id, f_name, l_name, salary, deduct_amount,"
                + "deduct_reason) values (?,?,?,?,?,?)";
        db.ps = db.con.prepareStatement(sql);
        db.ps.setString(1, deduction.getEmployeeId());
        db.ps.setString(2, deduction.getFirstName());
        db.ps.setString(3, deduction.getLastName());
        db.ps.setString(4, deduction.getSalary());
        db.ps.setString(5, deduction.getAmount());
        db.ps.setString(6, deduction.getReason());
        db.ps = db.con.prepareStatement(sql);
        db.ps.execute();
    }
}
