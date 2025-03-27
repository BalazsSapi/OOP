package oop.labor04.lab4_extra.utils;

import java.util.ArrayList;

public class Major {
    private static final ArrayList<String> majors = new ArrayList<String>();

    public Major() {
        majors.add("AUTOMATION_AND_APPLIED_INFORMATICS");
        majors.add("COMMUNICATION_AND_PUBLIC_RELATIONS");
        majors.add("COMPUTER_SCIENCE");
        majors.add("HORTICULTURAL_ENGINEERING");
        majors.add("INFORMATION_SCIENCE");
        majors.add("LANDSCAPE_ARCHITECTURE");
        majors.add("MANUFACTURING_ENGINEERING");
        majors.add("MECHATRONICS");
        majors.add("PUBLIC_HEALTH_SERVICES_AND_POLICIES");
        majors.add("TELECOMMUNICATION");
        majors.add("TRANSLATION_AND_INTERPRETING_STUDIES");
    }

    public static void addMajor(String major) {
        majors.add(major);
    }

    public static ArrayList<String> values() {
        return majors;
    }

    public static int valueOf(String major) {
        return  majors.indexOf(major);
    }

    public static String indexToString(int major) {
        return majors.get(major);
    }

    public static boolean containsMajor(String major) {
        return majors.contains(major);
    }
}
