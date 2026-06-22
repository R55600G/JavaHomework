package cn.henu.software.stu2510250128.ch07;

import java.io.File;

public class CheckExe {
    public static void main(String[] args) {
        String path = "D:\\Develop\\JavaHomework\\src\\cn\\henu\\software\\stu2510250128";
        File dir = new File(path);
        if (dir.exists() && dir.isDirectory()) {
            File[] allFiles = dir.listFiles();
            if (allFiles != null) {
                System.out.println("开始查找exe文件:");
                boolean isExe = false;
                for (File f : allFiles) {
                    if (f.isFile() && f.getName().toLowerCase().endsWith(".exe")) {
                        System.out.println("找到文件" + f.getName());
                        isExe = true;
                    }
                }
                if (isExe == false) {
                    System.out.println("找不到exe");
                }
            }
        } else {
            System.out.println("目录不存在或者他不是一个文件夹");
        }
    }
}
