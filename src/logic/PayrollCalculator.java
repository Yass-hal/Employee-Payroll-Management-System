package logic;

public class PayrollCalculator {
    public int increaseByPercent(int salary, int percent) {
        return salary / 100 * percent + salary;
    }

    public int increaseByAmount(int salary, int amount) {
        return salary + amount;
    }

    public int deductByPercent(int salary, int percent) {
        return salary - salary / 100 * percent;
    }

    public int deductByAmount(int salary, int amount) {
        return salary - amount;
    }

    public int deductionAmount(int salary, int remainingSalary) {
        return salary - remainingSalary;
    }

    public double overtimeHours(int hours) {
        double overtimeRate = 1.5;
        return hours * overtimeRate;
    }

    public double hourlyRate(int salary) {
        double days = 25;
        double hours = 8;
        return salary / days / hours;
    }

    public double totalAllowance(double overtime, double rate, int medical, int bonus, int other) {
        int extras = medical + bonus + other;
        return overtime * rate + extras;
    }
}
