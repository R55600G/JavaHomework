package cn.henu.software.stu2510250128.ch07;

import java.io.*;

public class CopySpecificFilesTest {
    public static void main(String[] args) {
        // 1. 设置源文件夹和目标文件夹的路径
        String srcDirPath = "D:\\Develop\\JavaHomework\\src\\cn\\henu\\software\\stu2510250128\\ch01"; // 假设这里面有我们以前写的 java 代码
        String destDirPath = "D:\\Develop\\JavaHomework\\JavaBackup"; // 专门存放备份的文件夹

        System.out.println("========== 实验 5：批量复制指定类型文件 ==========");

        File srcDir = new File(srcDirPath);
        File destDir = new File(destDirPath);

        // 2. 检查源文件夹是否存在
        if (!srcDir.exists() || !srcDir.isDirectory()) {
            System.out.println("错误：源文件夹不存在或不是一个目录！");
            return;
        }

        if (!destDir.exists()) {
            destDir.mkdirs();
            System.out.println("目标文件夹不存在，已自动创建：" + destDirPath);
        }

        // 4. 使用过滤器找出源文件夹下所有的 .java 文件
        File[] javaFiles = srcDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                // 忽略大小写
                return name.toLowerCase().endsWith(".java");
            }
        });

        // 5. 判断有没有找到符合条件的文件
        if (javaFiles == null || javaFiles.length == 0) {
            System.out.println("在源文件夹中没有找到任何 .java 文件。");
            return;
        }

        System.out.println(" 共找到 " + javaFiles.length + " 个 .java 文件，准备开始复制...");

        // 6. 遍历所有的 .java 文件，挨个进行复制
        int successCount = 0;
        for (File sourceFile : javaFiles) {

            File destFile = new File(destDir, sourceFile.getName());

            // 7. 采用最高效的“缓冲字节流 + 字节数组”方案进行复制
            try (
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile))
            ) {
                byte[] buffer = new byte[8192]; // 8KB 的大水桶
                int len;
                while ((len = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, len); //
                }
                System.out.println("  -> 成功复制：" + sourceFile.getName());
                successCount++;

            } catch (IOException e) {
                System.out.println("  -> 复制失败：" + sourceFile.getName());
                e.printStackTrace();
            }
        }

        System.out.println("\n 任务完成！共成功复制 " + successCount + " 个文件到：" + destDirPath);
    }
}