package cn.henu.software.stu2510250128.ch04;

public class Main {
    public static void main(String[] args) {
        Son son = new Son();
        son.method();
    }
}

class Parent {
    Parent() {
        System.out.println("Parent's Constructor without parameter");
    }

    Parent(boolean b) {
        System.out.println("Parent's Constructor with a boolean parameter");
    }

    public void method() {
        System.out.println("Parent's method()");
    }
}

class Son extends Parent {
    Son() {
        super(true);
        System.out.println("Son's Constructor without parameter");
    }

    @Override
    public void method() {
        System.out.println("Son's method()");
        super.method();
    }
}

