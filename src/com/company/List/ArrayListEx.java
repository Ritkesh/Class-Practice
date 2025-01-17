package com.company.List;

import java.util.*;

class MySort implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
class Student{
    private String name;
    private Double gpa;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
    public Student(String name, Double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

}

public class ArrayListEx {
    public static void main(String[] args) {
       // Without type safety
        System.out.println("Without type safety");
        ArrayList arr = new ArrayList();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add("John");
        arr.add("Daniel");
        //Printing using for loop
        System.out.println("Printing using for loop");
        for(int i = 0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }

        //printing using for each loop
        System.out.println("printing using for each loop");
        for (Object ob:arr) {
            System.out.println(ob);
        }
        // removing an element without using index
        System.out.println("removing an element without using index");
        arr.remove("John");
        for (Object ob:arr) {
            System.out.println(ob);
        }
//        adding element using index
        System.out.println(" adding element using index");
        arr.add(4,"John");
        for (Object ob:arr) {
            System.out.println(ob);
        }
        // removing element using index
        System.out.println("removing element using index");
        arr.remove(3);

        for (Object ob:arr) {
            System.out.println(ob);
        }
//        creating arraylist using array
        System.out.println("creating arraylist using array");

        List<Integer> intarr = Arrays.asList(1,2,3,4);
        for (int a:intarr) {
            System.out.println(a);
        }
        // we cannot add an element in intarr becuase it is created from a array whose size is fix
        System.out.println("we cannot add an element in intarr becuase it is created from a array whose size is fix");
//        intarr.add(4);
//        for (int a:intarr) {
//            System.out.println(a);
//        }

        // we can replace in intarr
        System.out.println("we can replace in intarr");

        intarr.set(0,9);
        for (int a:intarr) {
            System.out.println(a);
       }

        // we can convert arraylist into array
        System.out.println("we can convert arraylist into array");
        List<Integer> arrayconv = new ArrayList<>();
        arrayconv.add(9);
        arrayconv.add(10);
        arrayconv.add(11);
        arrayconv.add(12);
        Integer[] arraystring = arrayconv.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arraystring));

        // find the size of array before and afer deleting the element
        System.out.println("find the size of array before deleting the element");

        List<Integer> arrsize = new ArrayList<>();
        arrsize.add(18);
        arrsize.add(19);
        arrsize.add(20);
        arrsize.add(21);
        arrsize.add(22);
        System.out.println(arrsize.size());
        System.out.println("find the size of array  after deleting the element");
        arrsize.remove(0);
        arrsize.remove(Integer.valueOf(21));// if we pass value directly then it will consider it as index
        System.out.println(arrsize.size());

        // sorting of arraylist using sort method which will sort in ascending order
        System.out.println("sorting of arraylist using sort method which will sort in ascending order");
        List<Integer> arrSort = new ArrayList<>();
        arrSort.add(97);
        arrSort.add(87);
        arrSort.add(65);
        arrSort.add(54);
        arrSort.add(97);
        arrSort.sort(null);
        System.out.println(arrSort);
//        sorting of array by using comparator interface .it is an interface
        System.out.println("sorting of array by using comparator interface .it is an interface");
        arrSort.sort(new MySort());
        System.out.println(arrSort);

        //sorting using lambda expression
        System.out.println("sorting using lambda expression");
        List<Integer> arrSort1 = new ArrayList<>();
        arrSort1.add(900);
        arrSort1.add(99);
        arrSort1.add(87);
        arrSort1.add(34);
        arrSort1.add(90);
        arrSort1.add(78);
        arrSort1.add(65);
        arrSort1.sort((a,b)-> b-a);
        System.out.println(arrSort1);
// for sorting of string
        System.out.println("for sorting of string");
        List<String> name = new ArrayList<>();
        name.add("John");
        name.add("Daniel");
        name.add("Rock");
        name.sort(null);
        System.out.println(name);
        System.out.println("for sorting of string using lambda expression");
        name.sort((a,b)->a.length()-b.length());
        System.out.println(name);
        name.sort((a,b)-> b.length()-a.length());
        System.out.println(name);

        List<Student> st = new ArrayList<>();
        st.add(new Student("Alice",9.5));
        st.add(new Student("Charlie",9.5));
        st.add(new Student("Tom",9.8));
        st.add(new Student("Tania",7.6));

        // sort method only applicable on predefined data types not for user defined

//        st.sort(null);
        System.out.println("printing sorted student class object using lambda expression");
        st.sort((st1,st2)->{
            if(st1.getGpa()- st2.getGpa()>0){
                return 1;
            } else if(st1.getGpa()-st2.getGpa()<0){
                return -1;
            } else{
                return st1.getName().compareTo(st2.getName());
            }

        });

        for (Student student:st) {
            System.out.println(student.getName()+":"+" "+student.getGpa());
        }
        // sorting using comparator
         Comparator comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName).reversed();
        st.sort(comparator);
        System.out.println("printing student sorted by using comparator");
        for (Student student:st) {
            System.out.println(student.getName()+":"+" "+student.getGpa());
        }


    }





}
