package cn.henu.software.stu2510250128.ch03;

class Employee {
    private int id;
    private String name;
    private int age;
    private String position;
    private String department;
    public static int attendanceCount;

    public Employee() {
        this.setId(0);
        this.setName("Unknown");
        this.setAge(18);
        this.setPosition("Unknown");
        this.setDepartment("Unknown");
    }

    public Employee(int id, String name, int age, String position, String department) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
        this.setPosition(position);
        this.setDepartment(department);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            System.out.println("[系统拦截]工号不能为负!(" + id + ")已重置为0");
            this.id = 0;
        } else {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age > 65) {
            System.out.println("[系统拦截]" + this.name + "的年龄 (" + age + ") 不符合劳动法规定，已重置为 18 岁！");
            this.age = 18;
        } else {
            this.age = age;
        }
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void sign_in(String name) {
        Employee.attendanceCount++;
        System.out.println(name + "已签到，目前已有" + Employee.attendanceCount + "人签到");
    }

    public void displayInfo() {
        System.out.println("=====" + this.getName() + "的信息为====");
        System.out.println("id:" + this.getId());
        System.out.println("年龄:" + this.getAge());
        System.out.println("岗位:" + this.getPosition());
        System.out.println("部门:" + this.getDepartment());
    }

}

public class TestEmployee {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1001, "张三", 25, "后端开发工程师", "研发部");
        Employee emp2 = new Employee(-5, "李四", 12, "实习生", "市场部");
        Employee emp3 = new Employee();
        System.out.println("\n======= 2. 显示员工详细信息 =======");
        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();

        System.out.println("\n======= 3. 员工早晨打卡（测试 static 静态统计）=======");
        emp1.sign_in(emp1.getName());
        emp2.sign_in(emp2.getName());
        emp3.sign_in("神秘的默认员工");

        System.out.println("\n【HR后台数据】：今日全公司总出勤人数为 -> " + Employee.attendanceCount + " 人");
    }
}
