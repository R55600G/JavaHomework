package cn.henu.software.stu2510250128.ch04;

class Employee {
    protected String name;
    protected int age;
    protected String id;
    protected double salary;
    protected int workYears;

    public Employee(String name, int age, String id, int workYears, double salary) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.workYears = workYears;
        this.salary = salary;
    }

    public void raiseSalary() {
        salary = salary * 1.1;
    }

    public void display() {
        System.out.println(String.format("【员工】姓名: %s, 工号: %s, 当前工资: %.2f 元", name, id, salary));
    }
}

class Manager extends Employee {
    public Manager(String name, int age, String id, int workYears, double salary) {
        super(name, age, id, workYears, salary);
    }

    @Override
    public void raiseSalary() {
        salary = salary * 1.2;
    }

    @Override
    public void display() {
        System.out.println(String.format("【经理】姓名: %s, 工号: %s, 当前工资: %.2f 元", name, id, salary));
    }
}

public class CompanyTest {
    public static void main(String[] args) {
        Employee[] companyStaff = new Employee[3];
        companyStaff[0] = new Employee("小明", 20, "E001", 3, 3500);
        companyStaff[1] = new Employee("小李", 21, "E002", 5, 4000);
        companyStaff[2] = new Manager("老大", 30, "M001", 10, 6000);
        System.out.println("======调薪前======");
        for (int i = 0; i < companyStaff.length; i++) {
            companyStaff[i].display();
        }
        System.out.println("======调薪后======");
        for (int i = 0; i < companyStaff.length; i++) {
            companyStaff[i].raiseSalary();
            companyStaff[i].display();
        }
        System.out.println("======我的测试======");
        Employee manager2 = new Manager("老二", 30, "M002", 10, 6000);
        manager2.display();
        manager2.raiseSalary();
        manager2.display();
    }
}
