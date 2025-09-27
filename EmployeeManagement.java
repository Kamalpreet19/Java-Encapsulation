/*Build an employee management system with the following requirements:
Use an abstract class Employee with fields like employeeId, name, and baseSalary.
Provide an abstract method calculateSalary() and a concrete method displayDetails().
Create two subclasses: FullTimeEmployee and PartTimeEmployee, implementing calculateSalary() based on work hours 
or fixed salary.
Use encapsulation to restrict direct access to fields and provide getter and setter methods.
Create an interface Department with methods like assignDepartment() and getDepartmentDetails().
Ensure polymorphism by processing a list of employees and displaying their details using the Employee reference.*/

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public void setEmpId(int employeeId) {
        this.employeeId = employeeId;

    }

    public void setEmpName(String name) {
        this.name = name;

    }

    public void setEmpSalary(double baseSalary) {
        this.baseSalary = baseSalary;

    }

    public int getEmpId() {
        return employeeId;

    }

    public String getEmpName() {
        return name;

    }

    public double getEmpSalary() {
        return baseSalary;

    }

    abstract void calculateSalary();

    void displayDetails() {
        System.out.println("\nEmployee id : " + employeeId);
        System.out.println("Name : " + name);
        System.out.println("Base Salary : " + baseSalary);

    }

}

interface Department {
    public void assignDepartment(String deptName);

    public void getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
    private int hours;
    private String Department;

    FullTimeEmployee(int employeeId, String name, double baseSalary, int hours) {
        super(employeeId, name, baseSalary);
        this.hours = hours;

    }

    public void calculateSalary() {
        double bonus = 0;

        if (hours > 7) {
            bonus = 2000;
        } else {
            getEmpSalary();
        }
        System.out.println("Final salary (with bonus) :" + (getEmpSalary() + bonus));

    }

    public void assignDepartment(String deptName) {
        Department = deptName;

    }

    public void getDepartmentDetails() {
        System.out.println("Department : " + Department);

    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Department : " + Department);

    }
}

class PartTimeEmployee extends Employee implements Department {
    private int workingHours;
    private int hourlyRate;
    private String Department;

    PartTimeEmployee(int employeeId, String name, double baseSalary, int workingHours, int hourlyRate) {
        super(employeeId, name, baseSalary);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    public void calculateSalary() {
        double salary = hourlyRate * workingHours;
        System.out.println("Final salary ( Part-time ) " + (getEmpSalary() + salary));

    }

    public void assignDepartment(String deptName) {

        Department = deptName;

    }

    public void getDepartmentDetails() {
        System.out.println("Department : " + Department);

    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Department : " + Department);

    }

}

public class EmployeeManagement {
    public static void main(String args[]) {
        FullTimeEmployee emp = new FullTimeEmployee(11, "Kamal", 25000, 8);
        PartTimeEmployee emp1 = new PartTimeEmployee(12, "Tina", 1000, 12, 100);

        emp.assignDepartment("Finance");
        emp.displayDetails();
        emp.calculateSalary();

        emp1.assignDepartment("Sales");
        emp1.displayDetails();
        emp1.calculateSalary();

    }
}
