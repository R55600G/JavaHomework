package cn.henu.software.stu2510250128.ch02;

import java.util.Scanner;

class Student {
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}

public class T4_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入学生个数,至少2人:");
        int count = scan.nextInt();
        if (count < 2) {
            System.out.println("至少2名学生");
            scan.close();
            return;
        }
        Student top1 = new Student("AAA", -1.0);
        Student top2 = new Student("BBB", -1.0);
        for (int i = 1; i <= count; i++) {
            System.out.print("请输入第" + i + "个学生名字");
            String name = scan.next();
            System.out.print("请输入第" + i + "个学生成绩");
            double score = scan.nextDouble();
            Student currentStudent = new Student(name, score);
            if (currentStudent.getScore() > top1.getScore()) {
                top2 = top1;
                top1 = currentStudent;
            } else if (currentStudent.getScore() > top2.getScore()) {
                top2 = currentStudent;
            }
        }
        System.out.println("\n--- 成绩排名揭晓 ---");
        System.out.println("获得最高分的学生是：" + top1.getName() + "，分数：" + top1.getScore());
        System.out.println("获得第二高分的学生是：" + top2.getName() + "，分数：" + top2.getScore());

        scan.close();
    }
}
