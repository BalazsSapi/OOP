package oop.labor12.lab12_2;

import oop.labor12.lab12_2.Storage;

public class Main {
    public static void main(String[] args) {
        System.out.println(doIt("data1000000.txt","update10000000.txt"));
    }

    private static long doIt(String dataFilename, String updateFilename) {
        long startMillis = System.currentTimeMillis();
        Storage storage=new Storage(dataFilename);
        /*System.out.println("Original state:");
        System.out.println(storage);*/
        storage.update(updateFilename);
        /*System.out.println("\n\nUpdated state:");
        System.out.println(storage);*/
        long endMillis = System.currentTimeMillis();
        return endMillis - startMillis;
    }
}
