package org.example;

public class Employee {

    String name;
    Double salary;
    Double workHours;
    int year;


  /*  public Employee(String name, Double salary, Double workHours, int year) {
    }*/

    public double tax(Double salary){

        this.salary = salary;
        double tax = 0;
        if(salary>1000){
            tax = (salary*3)/100;
        }
        return tax;
    }
    public double bonus(double workHours,double salary){

        this.workHours = workHours;
        double hourlyPay = 30;
        double extraHours = 0;
        double salaryWithBonus = 0;

        if(workHours>40){
            extraHours = workHours - 40;
            salaryWithBonus = (extraHours*hourlyPay)+salary;
        }
        return salaryWithBonus;
    }

    public double raiseSalary(int year,double salary,double workHours){
        this.workHours = workHours;
        this.year = year;
        this.salary = salary;

        int currentDate = 2021;
        double newSalary = 0;
        int workYear = currentDate - year;

        if (workYear<10){
            newSalary = salary*1.05;
        }
        else if (workYear>9 && workYear<20 ) {
            newSalary = salary*1.10;
        }
        else if (workYear>19){
            newSalary = salary*1.15;
        }

        newSalary = bonus(workHours,salary); // salary'e bonus eklendi

        newSalary = newSalary-tax(newSalary); // tax düşüldü

        return newSalary;

    }

    public String toString(){
        return toString();
    }


    public static void main(String[] args) {
        Employee ee = new Employee();
        System.out.println(ee.tax(Double.valueOf(2000)));
        System.out.println(ee.bonus(Double.valueOf(45),2000));
        System.out.println(ee.raiseSalary(2015,2000,45));
        System.out.println("Hello world!");
    }
}