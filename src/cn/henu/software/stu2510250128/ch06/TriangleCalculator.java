package cn.henu.software.stu2510250128.ch06;

import java.util.InputMismatchException;
import java.util.Scanner;

class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }
}

public class TriangleCalculator {
    public static double calculateArea(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("边长应>0");
        }
        if (a + b <= c || b + c <= a || a + c <= b) {
            throw new IllegalTriangleException("两边之和应大于第三边");
        }
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("===三角形面积计算器===");
            System.out.println("请输入边长a");
            double a = scanner.nextDouble();
            System.out.println("请输入边长b");
            double b = scanner.nextDouble();
            System.out.println("请输入边长c");
            double c = scanner.nextDouble();
            int testDiv = 100 / (int) a;
            double area = calculateArea(a, b, c);
            System.out.println(" 计算成功！三角形的面积为: " + area);
        } catch (InputMismatchException e) {
            System.err.println("输入错误：请输入有效的数字！");
        } catch (ArithmeticException e) {
            System.err.println("算术异常捕获：发生了非法的数学运算（例如整数除以0）。详情: " + e.getMessage());

        } catch (IllegalTriangleException e) {
            System.err.println("几何逻辑错误：" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("发生未知异常：" + e.getMessage());
        } finally {
            System.out.println("--- 执行 finally 块：清理资源并关闭 Scanner ---");
            if (scanner != null) {
                scanner.close();
            }

        }
    }
}