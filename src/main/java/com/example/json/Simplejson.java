package com.example.json;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.sql.SQLOutput;
//import java.util.*;

public class Simplejson {

        public static void main(String[] args){
            List<Company> Monkeyc = new ArrayList<>();
            Monkeyc.add(new Company("Toyotaa"));
            Monkeyc.add(new Company("Japan"));
            Monkeyc.add(new Company("World"));

            List<Company> Tiger = new ArrayList<>();
            Tiger.add(new Company("German"));
            Tiger.add(new Company("Russia"));


            List<House> MonkeyHouse = new ArrayList<>();
            MonkeyHouse.add(new House(2004,"Flat"));

            List<House> TigerHouse = new ArrayList<>();
            TigerHouse.add(new House(1900,"Banglow"));

            List<Car> Monkeycar = new ArrayList<>();
            Monkeycar.add(new Car("Corolla",190,Monkeyc));

            List<Car> Tigercar = new ArrayList<>();
            Tigercar.add(new Car("BMW",2003,Tiger));

            List<Animals> animals = new ArrayList<>();
            animals.add(new Animals("Monkey",23,Monkeycar,MonkeyHouse));
            animals.add(new Animals("Tiger",40,Tigercar,TigerHouse));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
         String json = gson.toJson(animals);
         System.out.println("Output By Json : "+json);

            List<Animals> des = gson.fromJson(json, new TypeToken<List<Animals>>() {}.getType());
            for (Animals a : des) {
                System.out.println("Name : " + a.name + "\nAge : " + a.age);
                if (a.cars != null && !a.cars.isEmpty()) {
                    Car firstCar = a.cars.get(0);
                    System.out.print("Car: " + firstCar.model + ", Companies: ");
                    if (firstCar.companies != null) {
                        for (Company c : firstCar.companies) {
                            System.out.print(c.name + " ");
                        }
                    }
                    System.out.println();
                }
            }
    }
}
// @Data
class Animals{
     String name;
     int age;
     List<Car> cars;
     List<House> houses;
    public Animals(String name, int age , List<Car> cars,List<House> houses) {
        this.name = name;
        this.age = age;
        this.cars = cars;
        this.houses = houses;
    }
    public Animals(){}
}
class Car{
    String model;
    int year;
    List<Company> companies;
    public Car(String model, int year,List<Company> companies) {
        this.model = model;
        this.year = year;
        this.companies = companies;
    }
}
class House{
    int house_id;
    String cha;
    public House(int house_id, String cha) {
        this.house_id = house_id;
        this.cha = cha;
    }
}
class Company{
    String name;
    public Company(String name){
        this.name = name;
    }
}