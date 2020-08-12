package cn.com.lacus.www;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        System.out.println("HelloWorld");

        List<String> a = Arrays.asList("1","2","3","4");
        String s = String.join( "-",a);
        System.out.println(s);
        s = a.stream().collect(Collectors.joining("-"));
        System.out.println(s);
    }
}
