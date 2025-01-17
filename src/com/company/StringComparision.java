package com.company;

public class StringComparision {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 10;

        /** == is for data comparision in primitive data type , for other it is == methods present in object class
        is used which is reference comparision

         */
        System.out.println(num1 == num2);

        double d1 = 10.5;
        double d2 = 10.5;
        System.out.println(d1 == d2);

        boolean b1 = true;
        boolean b2 = true;
        System.out.println(b1 == b2);
        Integer int1 = 20;
        Integer int2 = 20;
        System.out.println(int1 == int2);
        Integer int3 = new Integer(10);
        Integer int4 = new Integer(10);
        System.out.println(int3 == int4);
         String s1 = "Ratan";
         String s2 = "Ratan";
        System.out.println(s1 == s2);
        String s3 = new String("Ratan");
        String s4 = new String("Ratan");
        System.out.println(s3 == s4);

        System.out.println("*****************");

        /** .equals in method in object class is used for reference comparison
        in string  clss .equals method is override and it is used for content comparision
         for other class object class .equls method is used.
         It is case sensistive.
         But if want to ignore the case then use equalIgnoreCase()
         */
        String str5 = new String("Ratan");
        String str6 = new String("Ratan");
        System.out.println(str5.equals(str6));
        System.out.println("-----------");
        StringBuffer stringBuffer1 = new StringBuffer("Ratan");
        StringBuffer stringBuffer2 = new StringBuffer("Ratan");
        System.out.println(stringBuffer1.equals(stringBuffer2));

        /** comparesTo() method compares the data and returns the integer.
         * It is case sensitive
         * compareToIgnoreCase() for ignoring the case
         * This method compares two string lexicographiclly. The comparision is
         * based on unicode value of each character of the strings.
         * If both the value are equals then return 0 otherwise returns +ve or -ve integer.
         * it compares the unicode chararcter wise
         * if first string unicode value is greater than second then returns +ve integer else returns
         * -ve integers and these return integers value depends on the difference of first string unicode
         * and second string unicode value
         *
         */

        System.out.println("compares to executed");
        String s7 = new String("Raja");
        String s8 = new String("Ratan");
        System.out.println(s7.compareTo(s8));
        String s9 = new String("Ratan");
        String s10 = new String("Ratan");
        System.out.println(s9.compareTo(s10));

        String str = "Burger";
        System.out.println(str.substring(1,6));

        StringBuffer buffer = new StringBuffer("Raja");
        buffer.append("Ratan");
        System.out.println(buffer);

        String st = "Raja";
        StringBuffer stb = new StringBuffer(st);
        System.out.println(stb.reverse());

        Float a = Float.valueOf(1000f);
        Float b = Float.valueOf(1000f);
        System.out.println(a);

        Integer c = Integer.valueOf(11);
        Integer d = Integer.valueOf(11);
        System.out.println(c == d);
        // lect 40 Encapsulation to read
        // lect 41 interface to read



    }
}
