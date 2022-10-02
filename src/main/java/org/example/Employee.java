package org.example;

public class Employee {

    String name;
    Double salary;
    Double workHours;
    int year;


    public Employee(String name, Double salary, Double workHours, int year) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.year = year;
    }

    public double tax(Double salary){

        double tax = 0;
        if(salary>1000){
            tax = (salary*3)/100;
            return tax;
        }else
            return 0;
    }
    public double bonus(double workHours,double salary) {

        double hourlyPay = 30;
        double extraHours = 0;
        double bonus = 0;

        if (workHours > 40) {
            extraHours = workHours - 40;
            bonus = (extraHours * hourlyPay);
        }
        return bonus;
    }

    public double raiseSalary(int year,double salary,double workHours){

        int currentDate = 2021;
        double raisedSalaryAmounth =0;
        double raisedSalary=0;

        int workYear = currentDate - year;

        if (workYear<10){
            raisedSalaryAmounth = salary*0.05;
        }
        else if (workYear>9 && workYear<20 ) {
            raisedSalaryAmounth = salary*0.10;
        }
        else if (workYear>19){
            raisedSalaryAmounth = salary*0.15;
        }
        raisedSalary = (raisedSalaryAmounth+bonus(workHours,salary)+salary);

        return raisedSalary;
    }

    public String toString(){

        double totalRaise = (bonus(workHours,salary)+(raiseSalary(year,salary,workHours)-salary));
        double raisedSalary = raiseSalary(year,salary,workHours);
        double tax = tax(raisedSalary);
        double raisedAmounth = raiseSalary(year,salary,workHours)-salary;
        double newSalary = raisedSalary;

        System.out.println("Employee name: "+name);
        System.out.println("Employee salary: "+salary);
        System.out.println("Employee workHours: "+workHours);
        System.out.println("Employee start year: "+year);
        System.out.println("Salary tax: "+ tax);
        System.out.println("Bonus amounth: "+bonus(workHours,salary));
        System.out.println("Raised amounth: "+raisedAmounth);
        System.out.println("Salary after bonus and raise: "+raisedSalary);
        System.out.println("New salary: "+(newSalary-tax(raisedSalary)));

        return null;
    }

    public static void main(String[] args) {
        Employee ee = new Employee("ahmet", 2000.0,50.0,2010);
        ee.toString();
    }
}
/* tax'in değeri doğru gelmiyor ve aslından yıldan gelen zam da gösterilebilir*/