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

    public ArrayList<String> values() {
        return majors;
    }

    public String valueOf(String major) {
        for (String m : majors) {
            if (m.equalsIgnoreCase(major)) {
                return m;
            }
        }
        System.out.println("Major not found!");
        return null;
    }

    public static boolean containsMajor(String major) {
        return majors.contains(major);
    }
}
