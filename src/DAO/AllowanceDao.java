package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.AllowanceData;

public class AllowanceDao {
    private final DatabaseSession db;

    public AllowanceDao(DatabaseSession db) {
        this.db = db;
    }

    public void save(AllowanceData allowance) throws SQLException {
        String sql = "insert into allowance (emp_id,f_name,l_name,"
                + "salary,medical,bonus,other,overtime,rate,total_allowance)"
                + "values(?,?,?,?,?,?,?,?,?,?)";
        db.ps = db.con.prepareStatement(sql);
        db.ps.setString(1, allowance.getEmployeeId());
        db.ps.setString(2, allowance.getFirstName());
        db.ps.setString(3, allowance.getLastName());
        db.ps.setString(4, allowance.getSalary());
        db.ps.setString(5, allowance.getMedical());
        db.ps.setString(6, allowance.getBonus());
        db.ps.setString(7, allowance.getOther());
        db.ps.setString(8, allowance.getOvertime());
        db.ps.setString(9, allowance.getRate());
        db.ps.setString(10, allowance.getTotal());
        db.ps.execute();
    }

    public List<AllowanceData> findAll() throws SQLException {
        db.stm = db.con.createStatement();
        db.rs = db.stm.executeQuery("SELECT * FROM allowance");
        List<AllowanceData> allowances = new ArrayList<AllowanceData>();
        while (db.rs.next()) {
            AllowanceData allowance = new AllowanceData();
            allowance.setEmployeeId(db.rs.getString("emp_id"));
            allowance.setFirstName(db.rs.getString("f_name"));
            allowance.setLastName(db.rs.getString("l_name"));
            allowance.setSalary(db.rs.getString("salary"));
            allowance.setMedical(db.rs.getString("medical"));
            allowance.setBonus(db.rs.getString("bonus"));
            allowance.setOther(db.rs.getString("other"));
            allowance.setOvertime(db.rs.getString("overtime"));
            allowance.setRate(db.rs.getString("rate"));
            allowance.setTotal(db.rs.getString("total_allowance"));
            allowances.add(allowance);
        }
        return allowances;
    }
}
