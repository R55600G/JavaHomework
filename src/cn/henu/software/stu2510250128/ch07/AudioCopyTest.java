package cn.henu.software.stu2510250128.ch07;

import java.io.*;

public class AudioCopyTest {
    public static void main(String[] args) {
        String sourcePath = "The Shore.mp3";
        String destPath1 = "copy1.mp3";
        String destPath2 = "copy2.mp3";
        System.out.println("========== 音频文件复制速度大比拼 ==========");
        System.out.println("===字节流===");
        long startTime1 = System.currentTimeMillis();
        //1. 字节流
        try (
                FileInputStream fis = new FileInputStream(sourcePath);
                FileOutputStream fos = new FileOutputStream(destPath1)
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length=fis.read(buffer))!=-1){
                fos.write(buffer, 0, length);
            }
            System.out.println("字节流文件完美复制");
        }catch (IOException e) {
            e.printStackTrace();
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("用时"+(endTime1-startTime1)+"ms");

        System.out.println("===字节缓冲流===");
        long startTime2 = System.currentTimeMillis();
        //2. 字节缓冲流
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath2));
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length=bis.read(buffer))!=-1){
                bos.write(buffer, 0, length);
            }
            System.out.println("缓冲字节流文件完美复制");
        }catch (IOException e) {
            e.printStackTrace();
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("用时"+(endTime2-startTime2)+"ms");
    }
}
