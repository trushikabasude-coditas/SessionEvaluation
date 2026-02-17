package week1;

import java.util.Scanner;

public class SalaryCalculationSystem {
//one abstarct method tohave the common behavior
    public static abstract class Employee {
        String name;
        double baseSalary;
        int attendanceDays;
        int rating;
        static final double PF_RATE=0.12;

        public Employee(String name, double baseSalary, int attendanceDays, int rating) {
            this.name=name;
            this.baseSalary =baseSalary;
            this.attendanceDays= attendanceDays;
            this.rating = rating;
        }
//one abstarct method
        abstract double calculateGrossSalary();
        public double calculateAttDeduction() {
            double dailySalary=baseSalary /30;
            int absentDays = 30 - attendanceDays;
            return absentDays * dailySalary;
        }

        public double performanceBonusCalculation() {
            double bonusPercent;
            switch (rating) {
                case 5:
                    bonusPercent=0.20;
                    break;
                case 4:
                    bonusPercent=0.15;
                    break;
                case 3:
                    bonusPercent=0.10;
                    break;
                case 2:
                    bonusPercent= 0.05;
                    break;
                default:
                    bonusPercent= 0.0;
            }
            return calculateGrossSalary() * bonusPercent;
        }

        public double calculatePF() {
            return baseSalary * PF_RATE;
        }

        public double calculateTax(double taxableIncome) {
            if (taxableIncome <= 50000)
                return taxableIncome * 0.05;
            else
                return taxableIncome * 0.10;
        }

        public double calculateNetSalary() {
            double gross=calculateGrossSalary();
            double bonus=performanceBonusCalculation();
            double deduction =calculateAttDeduction();
            double pf =calculatePF();
            double taxableIncome = gross + bonus - pf;
            double tax=calculateTax(taxableIncome);

            return gross + bonus - deduction - pf - tax;
        }
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        Employee employee;

        System.out.println("Select Employee:");
        System.out.println("1 Developer");
        System.out.println("2 Manager");
        System.out.println("3 Intern");
        int choice =sc.nextInt();//if click 1 then you are developer 2 manager 3 intern
        sc.nextLine();
        //takjing user inputs for name slaary attendance ratings
        System.out.print("Enter Name: ");
        String name= sc.nextLine();

        System.out.print("Enter Base Salary: ");
        double baseSalary =sc.nextDouble();

        System.out.print("Enter Attendance Days: ");
        int attendanceDays=sc.nextInt();

        System.out.print("Enter Rating (1-5): ");
        int rating=sc.nextInt();



        switch (choice) {
            case 1:
                System.out.print("Enter Overtime Hours: ");
                int overtime =sc.nextInt();
                employee =new Developer(name, baseSalary, attendanceDays, rating, overtime);
                break;

            case 2:
                System.out.print("Enter Team Size: ");
                int teamSize = sc.nextInt();
                employee =new Manager(name, baseSalary, attendanceDays, rating, teamSize);
                break;

            case 3:
                employee= new Intern(name, baseSalary, attendanceDays, rating);
                break;

            default:
                System.out.println("Enter the valid role...!!!");
                return;
        }

        System.out.println("Your Net Salary is: " +employee.calculateNetSalary());
    }
}
