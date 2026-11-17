package model;

import java.math.BigDecimal;
//Carries the completed payroll result
public record PayrollSummary(
        EmployeeInfo employee,
        BigDecimal totalAllowances,
        BigDecimal totalDeductions,
        BigDecimal netSalary
) {
    //Reads salary inside employeeInfo to avoid storing another copy inside this class
    public BigDecimal baseSalary() {
        return employee.baseSalary();
    }
}
