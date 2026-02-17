package week1;
public class Manager extends SalaryCalculationSystem.Employee{ //GrossSalary = BaseSalary + (OvertimeHours * 500)
     int TeamSize;
     public Manager(String name, double baseSalary, int attendanceDays, int Rating, int TeamSize) {
        super(name, baseSalary, attendanceDays, Rating);
        this.TeamSize = TeamSize;
    }

    @Override
    double calculateGrossSalary(){
        return baseSalary+(TeamSize * 1000);
    }
}
