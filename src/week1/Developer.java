package week1;

public class Developer extends SalaryCalculationSystem.Employee {//it is extending from parent employe class-so all method will pass here and for developer salary can be override to calculate its own 
    int overtimeHours;//asked for calculain based on overtimehors
    public Developer(String name, double baseSalary, int attendanceDays, int rating, int overtimeHours) {
        super(name, baseSalary, attendanceDays, rating);
        this.overtimeHours = overtimeHours;
    }
    @Override
    double calculateGrossSalary() {
        return baseSalary + (overtimeHours * 500);
    }
}
