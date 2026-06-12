package cn.henu.software.stu2510250128.ch05;

import java.util.HashSet;
import java.util.Objects;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + ":" + age;
    }
}

public class S5_12 {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("张三", 20));
        set.add(new Person("张三", 22));
        set.add(new Person("李四", 21));
        System.out.println(set);
    }
}
