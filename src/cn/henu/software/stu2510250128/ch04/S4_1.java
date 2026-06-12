package cn.henu.software.stu2510250128.ch04;

public class S4_1 {
    public static void main(String[] args) {
        // 创建 Animal 对象
        Animal animal = new Animal("普通动物", 5, "猫", "家里");
        // 创建 Monkey 对象
        Monkey monkey = new Monkey("悟空", 3, "猴子", "森林", "吃桃子", 45.5);

        // 调用 displayInfo()
        System.out.println("=== 动物信息 ===");
        animal.displayInfo();
        System.out.println("\n=== 猴子信息 ===");
        monkey.displayInfo();

        // 调用 makeSound()
        System.out.println("\n=== 发出声音 ===");
        animal.makeSound();
        monkey.makeSound();

        // 调用 eat()
        System.out.println("\n=== 吃东西 ===");
        animal.eat();
        monkey.eat();

        // 调用 climbTree()（只有猴子有）
        System.out.println("\n=== 爬树 ===");
        monkey.climbTree();
    }
}