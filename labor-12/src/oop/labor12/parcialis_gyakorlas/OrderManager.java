package oop.labor12.parcialis_gyakorlas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class OrderManager {

    HashMap<Integer,Customer> customers=readCustomersFromFile("customers.csv");
    HashMap<Integer,Order> orders=readOrdersFromFile("orders.csv");
    ArrayList<Shipment> shipments=readShipmentsFromFile("shipments.csv");

    public OrderManager(){

    }

    public void PartiallyCompletedOrders(){
        File file=new File("partially_completed_orders.csv");
        try (FileWriter fw=new FileWriter(file)){
            for(Integer key : orders.keySet()){
                if(orders.get(key).getAmount()!=0){
                    fw.write(key + ", " + orders.get(key).getProductId() + ", " + orders.get(key).getAmount() + "\n");
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("File writer error!");
        }
    }

    public TreeSet<String> CompaniesWithOrders(){
        TreeSet<String> companies=new TreeSet<>();
        for(Integer key: orders.keySet()){
            companies.add(customers.get(orders.get(key).getClientId()).getCompanyName());
        }
        return companies;
    }

    public int NumberOfInvalidShipments(){
        int count=0;
        for(Shipment shipment : shipments) {
            int key = shipment.getOrderId();
            Order order = orders.get(key);
            if(order==null){
                count++;
            }
            else {
                if (order.getProductId().equals(shipment.getProductId())==false) {
                    count++;
                }
            }
        }
        return count;
    }

    public int NumberOfPerfectlyExecutedOrders(){
        int count=0;
        for(Shipment shipment : shipments) {
            int key = shipment.getOrderId();
            Order order = orders.get(key);
            if (order.getProductId().equals(shipment.getProductId())) {
                order.shipAmount(shipment.getAmount());
                if (order.getAmount() == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static ArrayList<Shipment> readShipmentsFromFile(String filename){
        ArrayList<Shipment> shipments=new ArrayList<>();
        File file=new File(filename);

        try(Scanner sc=new Scanner(file)){
            while (sc.hasNextLine()){
                String line= sc.nextLine();
                String[] lineArr=line.split(",");
                shipments.add(new Shipment(Integer.parseInt(lineArr[0].trim()),lineArr[1].trim(),Integer.parseInt(lineArr[2].trim())));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found!");
        }
        return shipments;
    }

    public static HashMap<Integer,Customer> readCustomersFromFile(String filename){

        HashMap<Integer,Customer> customers=new HashMap<>();
        File file=new File(filename);

        try(Scanner sc=new Scanner(file)){
            while (sc.hasNextLine()){
                String line= sc.nextLine();
                String[] lineArr=line.split(",");
                customers.put(Integer.parseInt(lineArr[0].trim()),new Customer(Integer.parseInt(lineArr[0].trim()),lineArr[1].trim(),lineArr[2].trim(),lineArr[3].trim()));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found!");
        }
        return customers;
    }

    public static HashMap<Integer,Order> readOrdersFromFile(String filename){
        HashMap<Integer,Order> orders=new HashMap<>();
        File file=new File(filename);

        try(Scanner sc=new Scanner(file)){
            while (sc.hasNextLine()){
                String line= sc.nextLine();
                String[] lineArr=line.split(",");
                orders.put(Integer.parseInt(lineArr[0].trim()),new Order(Integer.parseInt(lineArr[0].trim()),Integer.parseInt(lineArr[1].trim()),lineArr[2].trim(),Integer.parseInt(lineArr[3].trim())));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found!");
        }
        return orders;
    }
}
