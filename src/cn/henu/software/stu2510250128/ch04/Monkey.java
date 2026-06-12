package cn.henu.software.stu2510250128.ch04;

public class Monkey extends Animal {
    private String hobby;
    private double weight;

    public Monkey(String name, int age, String species, String habitat, String hobby, double weight) {
        super(name, age, species, habitat);  // 调用父类构造方法
        this.hobby = hobby;
        this.weight = weight;
    }

    @Override
    public void makeSound() {
        System.out.println("The monkey says 'Ooh ooh ah ah'.");
    }

    @Override
    public void eat() {
        System.out.println("The monkey is eating bananas.");
    }

    public void climbTree() {
        System.out.println("The monkey " + getName() + " is climbing a tree.");
    }

    @Override
    public void displayInfo() {
        // 先调用父类方法显示基本信息
        super.displayInfo();
        // 再显示子类特有信息
        System.out.println("爱好：" + hobby);
        System.out.println("体重：" + weight);
    }

}
