package com.company.ArrayProg;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        String[] strArr = {"I am a boy","hi","hello"};
        Character[]charArr = {'a','b','c','d','e'};
        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.toString(charArr));
        System.out.println(Arrays.toString(arr));
        String[] strArrCopy = new String[strArr.length];
        System.arraycopy(strArr, 2, strArrCopy, 0, 0);

        // Print copied array
        System.out.println("Copied String Array: " + Arrays.toString(strArrCopy));

        String[] strArrClone = strArr.clone();
        System.out.println("Cloned String Array: " + Arrays.toString(strArrClone));
    }
}
