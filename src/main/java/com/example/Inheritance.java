package com.example;
class Person{
    String name;
    int age;
    Person(String name,int age){
        this.name = name;
        this.age = age;
}
void age()
{
    if (age>=19){
        System.out.println("You are an adult");
    }
    else{
        System.out.println("You are not an adult");
    }
}

}
class studentaa extends Person{
    String id;
    String gender;
    studentaa(String name,int age,String id,String gender){
        super(name,age);
        this.id = id;
        this.gender = gender;
    }
    void display(){
        System.out.println("Name: "+name+" Age: "+age+" ID: "+id+" Gender: "+gender);
    }
}
public class Inheritance{
    public static void main(String[] args){
        studentaa s1 = new studentaa("Faris",25,"1234567890","Male");
        s1.display();
    }
}