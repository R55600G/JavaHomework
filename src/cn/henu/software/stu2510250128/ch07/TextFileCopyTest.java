package cn.henu.software.stu2510250128.ch07;

import java.io.*;

public class TextFileCopyTest {
    public static void main(String[] args) {
        String srcPath = "source.txt";
        System.out.println("========== 字符流文本拷贝实验 ==========");
        createTestData(srcPath);

        // ------------------ 转换流 (InputStreamReader/OutputStreamWriter) ------------------
        System.out.println("1. 使用转换流拷贝...");
        // 方式一：单字符拷贝
        copyByTransformStreamSingleChar(srcPath, "dest1_transform_single.txt");
        // 方式二：字符数组拷贝
        copyByTransformStreamCharArray(srcPath, "dest2_transform_array.txt");

        // ------------------ 基础字符流 (FileReader/FileWriter) ------------------
        System.out.println("2. 使用基础字符流拷贝...");
        // 方式一：单字符拷贝
        copyByBasicCharStreamSingleChar(srcPath, "dest3_basic_single.txt");
        // 方式二：字符数组拷贝
        copyByBasicCharStreamCharArray(srcPath, "dest4_basic_array.txt");

        // ------------------ 缓冲字符流 (BufferedReader/BufferedWriter) ------------------
        System.out.println("3. 使用缓冲字符流的【特殊方法】拷贝...");
        copyByBufferedStreamSpecialMethod(srcPath, "dest5_buffered_special.txt");

        System.out.println("========== 所有拷贝任务圆满完成！ ==========");
    }

    // ====================================================================================
    // 方法 1A：转换流 + 单字符读取
    // ====================================================================================
    public static void copyByTransformStreamSingleChar(String src, String dest) {
        // 俄罗斯套娃：FileInputStream(字节流) -> 转换接头 -> InputStreamReader(字符流)
        try (
                InputStreamReader isr = new InputStreamReader(new FileInputStream(src));
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dest))
        ) {
            int ch;
            while ((ch = isr.read()) != -1) {
                osw.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ====================================================================================
    // 方法 1B：转换流 + 字符数组读取
    // ====================================================================================
    public static void copyByTransformStreamCharArray(String src, String dest) {
        try (
                InputStreamReader isr = new InputStreamReader(new FileInputStream(src));
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dest))
        ) {
            char[] buffer = new char[1024];
            int len;
            while ((len = isr.read(buffer)) != -1) {
                osw.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ====================================================================================
    // 方法 2A：基础字符流 + 单字符读取
    // ====================================================================================
    public static void copyByBasicCharStreamSingleChar(String src, String dest) {
        try (
                FileReader fr = new FileReader(src);
                FileWriter fw = new FileWriter(dest)
        ) {
            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ====================================================================================
    // 方法 2B：基础字符流 + 字符数组读取
    // ====================================================================================
    public static void copyByBasicCharStreamCharArray(String src, String dest) {
        try (
                FileReader fr = new FileReader(src);
                FileWriter fw = new FileWriter(dest)
        ) {
            char[] buffer = new char[1024];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ====================================================================================
    // 方法 3：缓冲字符流 + 特殊方法 (readLine & newLine)
    // ====================================================================================
    public static void copyByBufferedStreamSpecialMethod(String src, String dest) {
        try (
                BufferedReader br = new BufferedReader(new FileReader(src));
                BufferedWriter bw = new BufferedWriter(new FileWriter(dest))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 辅助方法：生成一个带中文的测试文件
    public static void createTestData(String path) {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write("Java I/O 流实验 3 测试数据\n");
            fw.write("Hello, World!\n");
            fw.write("转换流、字符流、缓冲流，绝不乱码！");
            System.out.println("测试文件 source.txt 已自动生成。\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}