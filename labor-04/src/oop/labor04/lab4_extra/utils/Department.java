package oop.labor04.lab4_extra.utils;

import java.util.ArrayList;

public class Department {
    private static final ArrayList<String> departments = new ArrayList<String>();

    public Department() {
        departments.add("APPLIED_LINGUISTICS");
        departments.add("APPLIED_SOCIAL_SCIENCE");
        departments.add("ELECTRICAL_ENGINEERING");
        departments.add("HORTICULTURE");
        departments.add("MATHEMATICS_INFORMATICS");
        departments.add("MECHANICAL_ENGINEERING");
    }

    public static void addDepartment(String department) {
        departments.add(department);
    }

    public static  ArrayList<String> values() {
        return departments;
    }

    public static int valueOf(String department) {
        return departments.indexOf(department);
    }

    public static String indexToString(int department) {
        return departments.get(department);
    }

    public static boolean containsDepartment(String department) {
        return departments.contains(department);
    }
}
