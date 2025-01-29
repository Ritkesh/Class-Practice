package com.company.java8features;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        // suplier does not take any argument but it has return

        Supplier<Integer> intSupplier = ()-> 1;

        System.out.println(intSupplier.get());
    }
}
