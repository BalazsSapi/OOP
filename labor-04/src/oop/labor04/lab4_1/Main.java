package oop.labor04.lab4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        readFromTextFile("lab4_1.in");
    }

    public static void readFromTextFile(String filename) {
        try (Scanner input = new Scanner(new File(filename))) {
            int lineCounter = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine();
                ++lineCounter;
                System.out.println(lineCounter + ". " + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File " + filename + " not found");
        }
        ArrayList<Person> persons = readFromCSVFile("lab4_1.csv");

        System.out.println("\nPersons list from CSV:");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    public static ArrayList<Person> readFromCSVFile(String fileName) {
        ArrayList<Person> persons = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] items = line.split(",");
                if (items.length != 3) continue;

                String firstName = items[0].trim();
                String lastName = items[1].trim();
                int birthYear = Integer.parseInt(items[2].trim());

                persons.add(new Person(firstName, lastName, birthYear));
            }
        } catch (FileNotFoundException e) {
            System.out.println("CSV file " + fileName + " not found.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing birth year in file " + fileName);
            e.printStackTrace();
        }
        return persons;
    }
}
