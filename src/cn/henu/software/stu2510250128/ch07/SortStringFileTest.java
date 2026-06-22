package cn.henu.software.stu2510250128.ch07;

import java.io.*;
import java.util.Arrays;

public class SortStringFileTest {
    public static void main(String[] args) {
        String srcPath = "s.txt";
        String destPath = "ss.txt";
        createSourceFile(srcPath);

        System.out.println("========== 文件读取与排序实验 ==========");

        try (
                BufferedReader br = new BufferedReader(new FileReader(srcPath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(destPath))
        ) {
            // ================= 步骤 A：读取数据 =================
            String line = br.readLine();
            if (line != null) {
                System.out.println("从 s.txt 读取到的原始数据：" + line);

                // ================= 步骤 B：处理数据 (排序) =================
                // 1. 把字符串打散成（char[]）
                char[] charArray = line.toCharArray();

                // 2. 调用 Java 提供的底层快排算法
                Arrays.sort(charArray);

                // 3. 把排好队的字符数组重新拼装成一个字符串
                String sortedString = new String(charArray);
                System.out.println("排序后的数据：" + sortedString);

                // ================= 步骤 C：写入数据 =================
                // 把排好序的字符串倒进新文件 ss.txt 里
                bw.write(sortedString);

                System.out.println("数据已成功排序并写入 " + destPath + "！");
            } else {
                System.out.println("源文件是空的！");
            }

        } catch (IOException e) {
            System.out.println("读写文件时发生错误！");
            e.printStackTrace();
        }
    }

    // 辅助方法：自动创建 s.txt 并写字符串
    private static void createSourceFile(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("hcexfgijkamdnoqrzstuvwybpl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}