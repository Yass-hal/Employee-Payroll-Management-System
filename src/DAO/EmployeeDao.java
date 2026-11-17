package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import model.Employee;

public class EmployeeDao {
    private final DatabaseSession db;

    public EmployeeDao(DatabaseSession db) {
        this.db = db;
    }

    public Employee findById(String id) throws SQLException {
        String sql = "select * from employee where emp_id=?";
        db.ps = db.con.prepareStatement(sql);
        db.ps.setString(1, id);
        db.rs = db.ps.executeQuery();
        if (!db.rs.next()) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(db.rs.getString("emp_id"));
        employee.setFirstName(db.rs.getString("f_name"));
        employee.setLastName(db.rs.getString("l_name"));
        employee.setGender(db.rs.getString("gender"));
        employee.setDateOfBirth(db.rs.getString("dob"));
        employee.setEmail(db.rs.getString("email"));
        employee.setContact(db.rs.getString("contact"));
        employee.setPresentAddress(db.rs.getString("p_add"));
        employee.setPermanentAddress(db.rs.getString("per_add"));
        employee.setHouse(db.rs.getString("house"));
        employee.setPostCode(db.rs.getString("pcode"));
        employee.setDepartment(db.rs.getString("dept"));
        employee.setDesignation(db.rs.getString("designation"));
        employee.setDateHired(db.rs.getString("date_hire"));
        employee.setSalary(db.rs.getString("salary"));
        employee.setJobTitle(db.rs.getString("job_t"));
        employee.setStatus(db.rs.getString("status"));
        employee.setImage(db.rs.getBytes("image"));
        return employee;
    }

    public void add(Employee employee, String imagePath) throws SQLException, IOException {
        String sql = "insert into employee"
                + "(emp_id, f_name, l_name, gender, dob, email, contact,"
                + "p_add, per_add, house, pcode, dept, designation, date_hire,"
                + "salary, job_t, status,image) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        db.ps = db.con.prepareStatement(sql);
        db.ps.setString(1, employee.getId());
        db.ps.setString(2, employee.getFirstName());
        db.ps.setString(3, employee.getLastName());
        db.ps.setString(4, employee.getGender());
        db.ps.setString(5, employee.getDateOfBirth());
        db.ps.setString(6, employee.getEmail());
        db.ps.setString(7, employee.getContact());
        db.ps.setString(8, employee.getPresentAddress());
        db.ps.setString(9, employee.getPermanentAddress());
        db.ps.setString(10, employee.getHouse());
        db.ps.setString(11, employee.getPostCode());
        db.ps.setString(12, employee.getDepartment());
        db.ps.setString(13, employee.getDesignation());
        db.ps.setString(14, employee.getDateHired());
        db.ps.setString(15, employee.getSalary());
        db.ps.setString(16, employee.getJobTitle());
        db.ps.setString(17, employee.getStatus());
        InputStream image = new FileInputStream(new File(imagePath));
        db.ps.setBlob(18, image);
        db.ps.execute();
    }

    public void delete(String id) throws SQLException {
        String sql = "delete from employee where emp_id = ?";
        db.ps = db.con.prepareStatement(sql);
        db.ps.setString(1, id);
        db.ps.execute();
    }

    public void update(Employee employee) throws SQLException {
        String sql = "update employee set emp_id ='"+employee.getId()+"',f_name ='"+employee.getFirstName()+"',"
                + "l_name = '"+employee.getLastName()+"',dob='"+employee.getDateOfBirth()+"',email='"+employee.getEmail()+"',contact='"+employee.getContact()+"',"
                +"p_add='"+employee.getPresentAddress()+"',per_add='"+employee.getPermanentAddress()+"',house='"+employee.getHouse()+"',pcode='"+employee.getPostCode()+"',"
                +"dept='"+employee.getDepartment()+"',designation='"+employee.getDesignation()+"',date_hire='"+employee.getDateHired()+"',salary='"+employee.getSalary()+"',"
                +"job_t='"+employee.getJobTitle()+"',status='"+employee.getStatus()+"' where emp_id='"+employee.getId()+"'  ";
        db.ps = db.con.prepareStatement(sql);
        db.ps.execute();
    }
}
