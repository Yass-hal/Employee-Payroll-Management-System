package logic;

import DAO.UserDao;
import employee_payroll.Emp;
import java.sql.SQLException;
import java.util.List;
import model.User;

public class LoginService {
    private final UserDao userDao;

    public LoginService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int login(String username, String password, String division) throws SQLException {
        List<User> users = userDao.findUsers(username, password, division);
        int count = 0;
        for (User user : users) {
            Emp.empId = user.getId();
            Emp.empName = user.getName();
            count++;
        }
        if (division == "Admin") {
            return count;
        }
        return -1;
    }
}
