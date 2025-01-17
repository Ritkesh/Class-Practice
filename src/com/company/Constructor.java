package com.company;

class Z {
    public Z() {
        System.out.println("In Z");
    }
    public Z(int p) {
        System.out.println("In int Z");
    }
}

 class A  extends Z{
    public A(){
        System.out.println("In A");
    }
    public A (int y){
        this();
        System.out.println("In int A");
    }
}
class B extends A{
    public B(){
        System.out.println("In B");
    }
    public B(int x){
        super(x);


        System.out.println("In int B");
    }

}
class Constructor {
    public static void main(String[] args) {
        B b = new B(5);
    }
}
