package com.company;

public class BreakInNestedLoop {
    public static void main(String[] args) {
        int p = 2;
        for(int i = 0 ; i<5;i++){
                for(int j = 0 ;j<5;j++){
                for(int k = 0 ;k<5;k++){
                    if(p ==2){
                        System.out.println(i);
                        break;
                    }
                    break;
                }
            }
                break;
        }
    }
}
