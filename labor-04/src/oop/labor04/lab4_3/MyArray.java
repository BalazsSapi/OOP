package oop.labor04.lab4_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyArray {
    private double[] data;

    // Constructor to create an array of given size
    public MyArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than zero.");
        }
        data = new double[size];
    }

    // Constructor to create a deep copy from a given array
    public MyArray(double[] array) {
        data = Arrays.copyOf(array, array.length);
    }

    // Constructor to create a deep copy from another MyArray object
    public MyArray(MyArray other) {
        this(other.data);
    }

    // Constructor to read data from a file
    public MyArray(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            if (!scanner.hasNextInt()) {
                throw new IllegalArgumentException("Invalid file format: missing size");
            }
            int size = scanner.nextInt();
            data = new double[size];

            for (int i = 0; i < size; i++) {
                if (scanner.hasNextDouble()) {
                    data[i] = scanner.nextDouble();
                } else {
                    throw new IllegalArgumentException("Invalid file format: missing elements");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found.");
            e.printStackTrace();
        }
    }

    // Fill the array with random numbers in the range [a, b)
    public void fillRandom(double a, double b) {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = a + (b - a) * random.nextDouble();
        }
    }

    // Compute the mean of the array
    public double mean() {
        if (data.length == 0) return 0;
        double sum = 0;
        for (double value : data) {
            sum += value;
        }
        return sum / data.length;
    }

    // Compute the standard deviation of the array
    public double stddev() {
        if (data.length == 0) return 0;
        double mean = mean();
        double sumSquaredDiffs = 0;
        for (double value : data) {
            sumSquaredDiffs += Math.pow(value - mean, 2);
        }
        return Math.sqrt(sumSquaredDiffs / data.length);
    }

    // Sort the array
    public void sort() {
        Arrays.sort(data);
    }

    // Print the elements of the array
    public void print(String label) {
        System.out.print(label + ": ");
        for (double value : data) {
            System.out.printf("%.2f ", value);
        }
        System.out.println();
    }
}
