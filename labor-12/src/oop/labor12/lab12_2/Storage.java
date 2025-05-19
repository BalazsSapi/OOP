package oop.labor12.lab12_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Storage {
    private HashMap<Integer, Product> products = new HashMap<>();

    public Storage(String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineArray = line.split(" ");
                int id = Integer.parseInt(lineArray[0]);
                String name = lineArray[1];
                int amount = Integer.parseInt(lineArray[2]);
                int price = Integer.parseInt(lineArray[3]);
                products.put(id, new Product(id, name, amount, price));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
    }

    public int update(String filename) {
        int count = 0;
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineArray = line.split(" ");
                int id = Integer.parseInt(lineArray[0]);
                int newAmount = Integer.parseInt(lineArray[1]);

                Product product = products.get(id);
                if (product != null) {
                    product.increaseAmount(newAmount);
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product p : products.values()) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }
}
