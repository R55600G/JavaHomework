package cn.henu.software.stu2510250128.ch05;

import java.util.TreeSet;

class Student implements Comparable<Student> {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score != o.score) {
            return Integer.compare(o.score, this.score);
        }
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + ":" + score;
    }
}

public class S5_13 {
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<>();
        set.add(new Student("张三", 85));
        set.add(new Student("李四", 92));
        set.add(new Student("王五", 92));
        set.add(new Student("赵六", 78));

        for (Student s : set) {
            System.out.println(s);
        }
    }
}
