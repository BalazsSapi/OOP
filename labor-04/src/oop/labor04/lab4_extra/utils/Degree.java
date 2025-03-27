package oop.labor04.lab4_extra.utils;

import java.util.ArrayList;

public class Degree {
    private static final ArrayList<String> degrees = new ArrayList<String>();
    public Degree() {
        degrees.add("ASSISTANT");
        degrees.add("ADJUNCT");
        degrees.add("PROFESSOR");
        degrees.add("DOCENT");
    }

    public static void addDegree(String degree) {
        degrees.add(degree);
    }

    public static ArrayList<String> values() {
        return degrees;
    }

    public static String indexToString(int degree) {
        return degrees.get(degree);
    }

    public static int valueOf(String degree) {
        return degrees.indexOf(degree);
    }

    public static boolean containsDegree(String degree) {
        return degrees.contains(degree);
    }
}
