package com.example.dataset;

public class DataSet {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setFirstName("John");
//        System.out.println(person.getFirstName());
//        System.out.println(person.getLastName());


        Person2 obje = new Person2();
        obje.setFirstName("Faris");
        obje.setLastName("Ahmed");
        System.out.println(obje.getFirstName());
        System.out.println(obje.getLastName());

    }
}
