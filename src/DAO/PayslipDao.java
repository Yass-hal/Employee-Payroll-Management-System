package DAO;

import java.sql.SQLException;

public class PayslipDao {
    private final DatabaseSession db;

    public PayslipDao(DatabaseSession db) {
        this.db = db;
    }

    public float calculateTotal(String employeeId, String salary) throws SQLException {
        String sql = "select * from deduction where emp_id= '" + employeeId + "'";
        db.ps = db.con.prepareStatement(sql);
        db.rs = db.ps.executeQuery();
        String value = db.rs.getString(5);
        String reason = db.rs.getString(6);
        db.rs.close();
        db.ps.close();

        String allowanceSql = "select * from allowance where emp_id= '" + employeeId + "'";
        db.ps = db.con.prepareStatement(allowanceSql);
        db.rs = db.ps.executeQuery();
        int baseSalary = Integer.parseInt(salary);
        float allowance = Float.valueOf(db.rs.getString(9));
        int deduction = Integer.parseInt(value);
        return baseSalary + allowance - deduction;
    }
}
