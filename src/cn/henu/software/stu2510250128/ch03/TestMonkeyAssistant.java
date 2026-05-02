package cn.henu.software.stu2510250128.ch03;

class MonkeyAssistant {
    private String name;
    private int age;
    private double weight;
    private String hobby;
    private double temperature;

    public MonkeyAssistant() {
        this.temperature = 0.0;
    }

    public MonkeyAssistant(String name, int age, double weight) {
        this.setName(name);
        this.setAge(age);
        this.setWeight(weight);
        this.setTemperature(0.0);
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
        if (age < 0) {
            System.out.println("猴子年龄不合法(" + age + ")已重置为0");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            System.out.println("猴子体重不合法(" + weight + ")已重置为10.0");
            this.weight = 10.0;
        } else {
            this.weight = weight;
        }
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        //如果温度太离谱就在这里作出限制
        this.temperature = temperature;
    }

    public double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }

    public double celsiusToFahrenheit(int celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    public double fahrenheitToCelsius(int fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    public void climbTree() {
        System.out.println("Monkey " + name + " is climbing a tree.");
    }

    public void printDetails() {
        System.out.println("猴子的名字:" + name);
        System.out.println("猴子的年龄:" + age + "岁");
        System.out.println("猴子的体重:" + weight + "kg");
        System.out.println("猴子的爱好:" + hobby);
    }
}

public class TestMonkeyAssistant {
    public static void main(String[] args) {
        System.out.println("====== 1. 创建猴子助手 ======");
        // assistant1：使用默认构造方法创建
        MonkeyAssistant assistant1 = new MonkeyAssistant();
        assistant1.setName("xuyoyodpp");
        assistant1.setAge(500);
        assistant1.setWeight(1000000);
        assistant1.setHobby("当浪神的儿子");
        System.out.println("助手1创建完毕");
        // assistant2：使用带有参数的构造方法创建
        MonkeyAssistant assistant2 = new MonkeyAssistant("皮皮", 2, 48.0);
        assistant2.setHobby("敲代码");
        System.out.println("助手1创建完毕");

        System.out.println("\n====== 2. 打印详细信息 ======");
        System.out.println("助手1信息 -> ");
        assistant1.printDetails();
        System.out.println("助手2信息 -> ");
        assistant2.printDetails();

        System.out.println("\n====== 3. 爬树行为测试 ======");
        assistant1.climbTree();
        assistant2.climbTree();

        System.out.println("\n====== 4. 温度转换功能测试 ======");
        // 使用 assistant1 测试摄氏度转华氏度 (传入 int 类型参数)
        int celsiusTemp = 30;
        double fResult = assistant1.celsiusToFahrenheit(celsiusTemp);
        System.out.println("助手 " + assistant1.getName() + " 计算: " + celsiusTemp + " 摄氏度 = " + fResult + " 华氏度");

        // 使用 assistant2 测试华氏度转摄氏度 (传入 double 类型参数)
        double fahrenheitTemp = 100.4;
        double cResult = assistant2.fahrenheitToCelsius(fahrenheitTemp);
        // 使用 String.format 稍微格式化一下输出，保留两位小数
        System.out.println("助手 " + assistant2.getName() + " 计算: " + fahrenheitTemp + " 华氏度 = " + String.format("%.2f", cResult) + " 摄氏度");
    }
}
