package com.company;

 class MethodOverriding {

      void m1(){
           System.out.println("Private method");
       }  // over ridden method
    }
    class Child extends MethodOverriding{
        void m1(){   //over riding method
           System.out.println("method override");

        }

        public static void main(String[] args) {
            Child c1 = new Child();
            c1.m1();


        }
    }

