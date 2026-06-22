package cn.henu.software.stu2510250128.ch07;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student other) {
        return other.score-this.score;
    }

    @Override
    public String toString() {
        return "姓名: " + name + "\t成绩: " + score;
    }

}

public class KeyboardToFileTest {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "student_record.txt";
        System.out.println("========== 实验 4：键盘录入与文件读写 ==========");

        // =====================================================================
        // 任务 1A：向指定的 txt 文件中写入键盘输入的内容
        // =====================================================================
        System.out.println("【第一阶段】请输入要写入文件的内容 (输入 'exit' 结束):");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            while (true) {
                String line = scanner.nextLine();
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }
                bw.write(line);
                bw.newLine();
            }
            System.out.println("键盘内容已成功写入文件！\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // =====================================================================
        // 任务 1B：重新读取该文件的内容，显示到控制台上
        // =====================================================================
        System.out.println("【第二阶段】重新读取文件内容如下：");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("读取完毕！\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // =====================================================================
        // 任务 2A：键盘录入 5 个学生信息并按成绩从高到低排序
        // =====================================================================
        System.out.println("【第三阶段】请录入 5 个学生的信息：");
        List<Student> studentList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            System.out.print("请输入第 " + i + " 个学生的姓名: ");
            String name = scanner.next();
            System.out.print("请输入第 " + i + " 个学生的成绩: ");
            int score = scanner.nextInt();
            studentList.add(new Student(name, score));
        }

        // 核心：调用集合工具类，根据 Student 类里写的规则进行降序排序
        Collections.sort(studentList);
        // =====================================================================
        // 任务 2B：追加存入上述的文本文件中
        // =====================================================================
        System.out.println("\n正在将排序后的学生信息【追加】到文件中...");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.newLine();
            bw.write("--- 以下是成绩排名前 5 的学生名单 ---");
            bw.newLine();

            for (Student stu : studentList) {
                bw.write(stu.toString());
                bw.newLine();
            }
            System.out.println(" 学生信息追加写入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // （附加验证）最后再读取一次全文件，看看追加到底成没成功
        System.out.println("\n【最终验证】文件的全部内容如下：");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }


}
