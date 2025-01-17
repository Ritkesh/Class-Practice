package com.company;

import java.util.ArrayList;
import java.util.ListIterator;

public class CursorEx5 {
    public static void main(String[] args) {
        ArrayList<Emplyoee> emp = new ArrayList<Emplyoee>();
        emp.add(new Emplyoee(111,"durga"));
        emp.add(new Emplyoee(222,"sravya"));
        emp.add(new Emplyoee(333,"Lipika"));
        ListIterator<Emplyoee> listIterator = emp.listIterator();
        listIterator.add(new Emplyoee(444,"monu"));
        while(listIterator.hasNext()){
            Emplyoee emplyoee = listIterator.next();
            if(emplyoee.empid==111){
                listIterator.remove();
            }
            if(emplyoee.empid==222){
                emplyoee.empName = "Sarika";
                listIterator.set(emplyoee);
            }
        }
        for (Emplyoee e:emp) {
            System.out.println(e.empid + ": "+e.empName);

        }
    }
}
