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

        this.salary = salary;
        double tax = 0;
        if(salary>1000){
            tax = (salary*3)/100;
        }
        return tax;
    }
    public double bonus(double workHours,double salary){
        this.salary = salary;
        this.workHours = workHours;
        double hourlyPay = 30;
        double extraHours = 0;
        double salaryWithBonus = 0;

        if(workHours>40){
            extraHours = workHours - 40;
            salaryWithBonus = (extraHours*hourlyPay)+salary;
            return salaryWithBonus;
        }else{
            return salary;
        }

    }

    public double raiseSalary(int year,double salary,double workHours){
        this.workHours = workHours;
        this.year = year;
        this.salary = salary;

        int currentDate = 2021;
        double newSalary = 0;
        double raisedSalary =0;
        double bonusAmounth =0;
        int workYear = currentDate - year;


        if (workYear<10){
            raisedSalary = salary*1.05;
        }
        else if (workYear>9 && workYear<20 ) {
            raisedSalary = salary*1.10;
        }
        else if (workYear>19){
            raisedSalary = salary*1.15;
        }

        bonusAmounth = bonus(workHours,salary)- salary;
        newSalary = bonus(workHours,raisedSalary); // salary'e bonus eklendi
        newSalary = newSalary-tax(newSalary); // tax düşüldü

        System.out.println("Bonus amounth "+bonusAmounth);
        System.out.println("Salary after bonus and raise "+bonus(workHours,raisedSalary));
        System.out.println("Salary tax "+ tax(newSalary));
        System.out.println("Total Amount of raise "+(newSalary-salary));
        System.out.println("New salary "+newSalary);

        return newSalary;

    }

    public void information(){
        System.out.println("Employee name: "+name);
        System.out.println("Employee salary: "+salary);
        System.out.println("Employee workHours: "+workHours);
        System.out.println("Employee start year: "+year);
        System.out.println("Employee new salary:"+raiseSalary(year,salary,workHours));
    }


    public static void main(String[] args) {
        Employee ee = new Employee("ahmet", 3000.0,50.0,2005);
        ee.information();

    }
}