package info;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("1", 89);
        Map map2 = new HashMap<>();
    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i = 0; i < length; i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
