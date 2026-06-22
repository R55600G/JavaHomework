package cn.henu.software.stu2510250128.ch06;

import java.util.Scanner;

class NotATriangleException extends Exception {
    public NotATriangleException() {
        super();
    }

    public NotATriangleException(String message) {
        super(message);
    }
}

public class TriangleTest {
    public static void checkTriangle(double a, double b, double c) throws NotATriangleException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new NotATriangleException("错误：边长 " + a + ", " + b + ", " + c + " 无法构成三角形！(任意两边之和必须大于第三边)");
        }
        System.out.println("校验通过：边长 " + a + ", " + b + ", " + c + " 可以完美构成一个三角形。");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("=== 三角形校验测试 ===");
            System.out.print("请输入第一条边长: ");
            double a = scanner.nextDouble();

            System.out.print("请输入第二条边长: ");
            double b = scanner.nextDouble();

            System.out.print("请输入第三条边长: ");
            double c = scanner.nextDouble();

            checkTriangle(a, b, c);
        } catch (NotATriangleException e) {
            System.err.println("\n【捕获到自定义异常】");
            System.err.println("异常信息: " + e.getMessage());
            System.err.println("异常堆栈跟踪:");
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("发生了其他输入或运行错误：" + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
                System.out.println("\n--- 扫描器资源已释放 ---");
            }
        }

    }
}
