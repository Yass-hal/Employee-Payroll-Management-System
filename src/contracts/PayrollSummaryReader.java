package contracts;

import exceptions.PersistenceException;
import exceptions.ValidationException;
import java.util.Optional;
import model.PayrollSummary;
//Return payrollSummary or Optional.empty() if the employee is not found
public interface PayrollSummaryReader {
    Optional<PayrollSummary> getSummary(String employeeId)throws PersistenceException,ValidationException;
}
