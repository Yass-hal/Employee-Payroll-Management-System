package model;

import java.math.BigDecimal;
//Record to carry the info of employee needed by payroll and reporting from the database 

public record EmployeeInfo(
        String id,
        String firstName,
        String lastName,
        String dateOfBirth,
        String department,
        String designation,
        String dateHired,
        String jobTitle,
        String status,
        //Used BigDecimal to prevent small inaccuracies
        BigDecimal baseSalary
) {}
