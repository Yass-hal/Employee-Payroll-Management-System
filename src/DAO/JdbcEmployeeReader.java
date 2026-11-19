package DAO;

import contracts.EmployeeReader;
import exceptions.PersistenceException;
import exceptions.ValidationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;
import model.EmployeeInfo;

public class JdbcEmployeeReader implements EmployeeReader {
    private final ConnectionProvider connectionProvider;

    public JdbcEmployeeReader(ConnectionProvider connectionProvider) {
        this.connectionProvider = Objects.requireNonNull(connectionProvider);
    }

    @Override
    public Optional<EmployeeInfo> findById(String employeeId) {
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new ValidationException("Enter an employee ID.");
        }

        String sql = "SELECT emp_id, f_name, l_name, dob, dept, designation, "
                + "date_hire, job_t, status, salary FROM employee WHERE emp_id = ?";

        try (Connection connection = connectionProvider.openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employeeId.trim());

            try (ResultSet results = statement.executeQuery()) {
                if (!results.next()) {
                    return Optional.empty();
                }

                EmployeeInfo employee = new EmployeeInfo(
                        results.getString("emp_id"),
                        results.getString("f_name"),
                        results.getString("l_name"),
                        results.getString("dob"),
                        results.getString("dept"),
                        results.getString("designation"),
                        results.getString("date_hire"),
                        results.getString("job_t"),
                        results.getString("status"),
                        results.getBigDecimal("salary"));
                return Optional.of(employee);
            }
        } catch (SQLException e) {
            throw new PersistenceException("Cannot read employee information.", e);
        }
    }
}
