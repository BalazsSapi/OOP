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

    public ArrayList<String> values() {
        return degrees;
    }

    public String valueOf(String degree) {
        for (String d : degrees) {
            if (d.equalsIgnoreCase(degree)) {
                return d;
            }
        }
        System.out.println("Degree not found!");
        return null;
    }

    public static boolean containsDegree(String degree) {
        return degrees.contains(degree);
    }
}
