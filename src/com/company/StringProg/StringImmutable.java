package com.company.StringProg;

public class StringImmutable {


    public static void main(String[] args) {
        String str = "Ritkesh";
        String str2 = str.concat("Singh");
        str =str2;
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str.toString());
        StringBuffer buffer = new StringBuffer("Ritkesh");
        buffer.append("singh");
        System.out.println(buffer);

    }
}
