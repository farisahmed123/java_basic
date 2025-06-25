package com.example;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

class Data{
    int amount;
    String type;
    String head;
    String date;
    Data(int amount,String type,String head,String date){
        this.amount = amount;
        this.type=type;
        this.head=head;
        this.date=date;
    }
    public String tostring(){
        return type +"," + head + "," + amount + "," + date;
    }
    public static Data fromString(String line) {
        String[] parts = line.split(",");

        String type = parts[0];
        String head = parts[1];
        int amount = Integer.parseInt(parts[2]);
        String date = parts[3];

        return new Data(amount, type, head, date);
    }

}
public class Faris {
    static Scanner scanner = new Scanner(System.in);
    static List<Data> records = new ArrayList<>();
    final static String File_name = "Helo.txt";
    public static void main(String[] args){
        loadData();
        while(true){
            System.out.println("1. Add income : ");
            System.out.println("2. Add Expense : ");
            System.out.println("3. Show Report");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice)
            {
                case 1 :
                    addentry("Income");
                    break;

                case 2 :
                    addentry("Expense");
                    break;

                case 3 :
                    showReport();
                    break;

                case 4:
                    saveData();
                    System.exit(0);
            }
        }
    }

    private static void addentry(String type)
    {
        System.out.print("Enter "+type+"Head : ");
        String head = scanner.next();
        double total = 0.0;
        for (Data e:records){
            if(e.type.equals(type) && e.head.equalsIgnoreCase(head))
            {
                total = total + e.amount;
            }
        }
        if(total > 0){
            System.out.println(type+"head is already exist with "+total+"Do you want more (y/n) :");
            String ans = scanner.nextLine();
            if (!ans.equalsIgnoreCase("n")) return;
        }
        System.out.print("Enter amount :");
        int amount = scanner.nextInt();
        scanner.nextLine();


        String date = LocalDate.now().toString();
        Data data = new Data(amount,type,head,date);
        records.add(data);

        double newTotal = 0.0;
        for (Data d : records){
            if (d.type.equals(type))
            {
                newTotal = newTotal + d.amount;
            }
        }
        System.out.println(type + " added to " + head + " head. Total " + type + " is now " + newTotal);
    }

    static void showReport()
    {
        System.out.println("Income Report:");
        showreportdetail("Income");

        System.out.println("Expense Report:");
        showreportdetail("Expense");
    }

    static void showreportdetail(String type)
    {
        double total = 0.0;
        for (Data d: records){
            if(d.type.equals(type))
            {
                System.out.println("Head: " + d.head + ", Amount: " + d.amount + ", Date: " + d.date);
                total = total + d.amount;
            }
        }
        System.out.println("Total : "+total);
    }

    static void loadData()
    {
        try{
            File file = new File(File_name);
            if(!file.exists()) return;
            Scanner fileScanner = new Scanner(file);
            while(fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                records.add(Data.fromString(line));
            }
            fileScanner.close();
        }
        catch (IOException e) {
            System.out.println("Failed to load data.");
        }
    }

    private static void saveData() {
        try {
            FileWriter fw = new FileWriter(File_name);
            for (Data d : records) {
                fw.write(d.tostring() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Failed to save data.");
        }
    }
}
