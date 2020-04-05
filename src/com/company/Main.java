package com.company;

public class Main {

    public static void main(String[] args) {
        Optional<Integer> ob1 = new Optional<Integer>();
        ob1.setValue(1);
        int v1 = ob1.getValue();
        System.out.println(v1);

        Optional ob3 = new Optional();
        System.out.println(ob3.getValue());
        ob3.setValue("Java SE 7");
        System.out.println(ob3.toString());
        ob3.setValue(71);
        System.out.println(ob3.toString());

    }
}
