package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Round {
    private static double round(double value, int places,RoundingMode roundingMode) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places,roundingMode);
        return bd.doubleValue();
    }

    public static void main(String[] args) {
        int decimal = 0;
        System.out.println(round(87.768,0,RoundingMode.FLOOR));
        try {
            int test = Integer.parseInt("Ritkesh");
            System.out.println(test);
        } catch (Exception e){
            System.out.println("hi");
        }

    }
}
