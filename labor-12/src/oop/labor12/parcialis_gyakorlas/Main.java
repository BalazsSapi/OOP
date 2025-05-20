package oop.labor12.parcialis_gyakorlas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        OrderManager manager=new OrderManager();
        System.out.println("Perfect shipments: " + manager.NumberOfPerfectlyExecutedOrders());
        System.out.println("Invalid shipments: " + manager.NumberOfInvalidShipments());
        TreeSet<String> companies=manager.CompaniesWithOrders();
        System.out.println("Companies with orders (" + companies.size() + " companies):");
        for(String str: companies){
            System.out.println(str);
        }
        manager.PartiallyCompletedOrders();

    }
}
