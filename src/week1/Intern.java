package week1;

public class Intern extends SalaryCalculationSystem.Employee {

    public Intern(String name, double baseSalary, int attendanceDays, int rating) {
        super(name, baseSalary, attendanceDays, rating);
    }

    @Override
    double calculateGrossSalary() {
        double attendancePercent = (attendanceDays / 30.0) * 100;

        if (attendancePercent < 70) {
            return baseSalary - (baseSalary * 0.20);
        } else {
            return baseSalary;
        }
    }
}
