package logic;

import contracts.EmployeeReader;
import exceptions.ValidationException;
import java.util.Objects;
import java.util.Optional;
import model.EmployeeInfo;

public class EmployeeService {
    private final EmployeeReader employeeReader;

    public EmployeeService(EmployeeReader employeeReader) {
        this.employeeReader = Objects.requireNonNull(employeeReader);
    }

    public Optional<EmployeeInfo> findById(String employeeId) {
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new ValidationException("Enter an employee ID.");
        }
        return employeeReader.findById(employeeId.trim());
    }
}
