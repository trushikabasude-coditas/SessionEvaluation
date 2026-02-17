package week1;

public class Developer extends SalaryCalculationSystem.Employee {

    int overtimeHours;

    public Developer(String name, double baseSalary, int attendanceDays, int rating, int overtimeHours) {
        super(name, baseSalary, attendanceDays, rating);
        this.overtimeHours = overtimeHours;
    }

    @Override
    double calculateGrossSalary() {
        return baseSalary + (overtimeHours * 500);
    }
}
