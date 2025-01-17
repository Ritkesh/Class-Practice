package com.company.ArrayProg;

public class InterviewPrepration2 {

    public void findDuplicate(int[]arr){
        boolean[] traversed = new boolean[arr.length];
        for(int i = 0;i<arr.length;i++){
            boolean duplicate = false;
            if(traversed[i])continue;
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    traversed[j] = true;
                    duplicate = true;
                }
            }
            if(duplicate){
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        InterviewPrepration2 prepration2 = new InterviewPrepration2();
        int[]arr  = {1,2,3,4,2,6,5,4,5,4};
        prepration2.findDuplicate(arr);
    }
}
