package cn.henu.software.stu2510250128.ch04;

interface Shape {
    public double length();
}

// 1. 三角形类
class Triangle implements Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Override
    public double length() {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 0;
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            return 0;
        }

        return a + b + c;
    }
}

// 2. 长方形类
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double length() {
        if (width <= 0 || height <= 0) {
            return 0;
        }
        return 2 * (width + height);
    }
}

// 3. 圆形类
class Circle implements Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double length() {
        if (r <= 0) {
            return 0;
        }
        return 2 * 3.14 * r;
    }
}

// 4. 测试类
public class ShapeTest {
    public static void main(String[] args) {
        Shape shape;

        System.out.println("====== 测试三角形 ======");
        shape = new Triangle(3, 4, 5);
        System.out.println("边长为 3, 4, 5 的三角形周长: " + shape.length());

        shape = new Triangle(1, 2, 3);
        System.out.println("边长为 1, 2, 3 的三角形周长: " + shape.length());

        System.out.println("\n====== 测试长方形 ======");
        shape = new Rectangle(4, 5);
        System.out.println("长宽为 4, 5 的长方形周长: " + shape.length());

        shape = new Rectangle(-4, 5);
        System.out.println("长宽为 -4, 5 的长方形周长: " + shape.length());

        System.out.println("\n====== 测试圆形 ======");
        shape = new Circle(2);
        System.out.println("半径为 2 的圆形周长: " + shape.length());

        shape = new Circle(0);
        System.out.println("半径为 0 的圆形周长: " + shape.length());
    }
}