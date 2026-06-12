package cn.henu.software.stu2510250128.ch05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class S5_8 {
    public static void main(String[] args) {
        String s = "中华人民共和国成立于1949年10月1日";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
