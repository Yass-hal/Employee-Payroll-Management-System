package contracts;

import exceptions.PersistenceException;
import exceptions.ValidationException;
import java.util.Optional;
import model.EmployeeInfo;

public interface EmployeeReader {
    //Every implmentation return employee information or empty if not found
    Optional<EmployeeInfo> findById(String employeeId)throws ValidationException,PersistenceException;
}
