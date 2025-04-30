package oop.labor10.lab10_1;

public class Main {
    public static void main(String[] args) {
        SortingDemo demo=new SortingDemo("fruits.txt");
        System.out.println("Original data:");
        demo.printFruits();
        System.out.println();
        System.out.println("Alphabetically sorted data:");
        demo.sortAlphabetically();
        demo.printFruits();
        System.out.println();
        System.out.println("Reverse alphabetically sorted data:");
        demo.sortReverseAlphabetically();
        demo.printFruits();
        System.out.println();
    }
}
