package oop.labor10.lab10_3;

import oop.labor10.lab10_2.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Company {
    private String name;
    private ArrayList<Employee> employees=new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void hireAll(String filename){
        File file = new File(filename);
        try(Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] lineArr = line.split(",");
                if(lineArr.length==7){
                    employees.add(new Manager(lineArr[1].trim(),lineArr[0].trim(), Double.parseDouble(lineArr[2].trim()), new MyDate(Integer.parseInt(lineArr[3].trim()),Integer.parseInt(lineArr[4].trim()),Integer.parseInt(lineArr[5].trim())), lineArr[6].trim()));
                }
                else{
                    employees.add(new Employee(lineArr[1].trim(),lineArr[0].trim(),Double.parseDouble(lineArr[2].trim()),new MyDate(Integer.parseInt(lineArr[3].trim()),Integer.parseInt(lineArr[4].trim()),Integer.parseInt(lineArr[5].trim()))));
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public void fire(int index){
        employees.remove(index);
    }

    public void printAll(PrintStream printStream){
        for(Employee employee:employees){
            printStream.println(employee);
        }
    }

    public void printMenagers(PrintStream printStream){
        for(Employee employee:employees){
            if(employee instanceof Manager){
                printStream.println(employee);
            }
        }
    }

    public void sortByComparator(Comparator<Employee> comparator){
        Collections.sort(employees,comparator);
    }
}
