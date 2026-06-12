package cn.henu.software.stu2510250128.ch05;

import java.util.HashMap;
import java.util.Map;

public class S5_15 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("admin", "123456");
        map.put("user1", "abcde");
        map.put("user2", "qwerty");
        map.put("guest", "guest123");
        map.put("test", "testpwd");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("用户名: " + entry.getKey() + " , 密码: " + entry.getValue());
        }
    }
}
