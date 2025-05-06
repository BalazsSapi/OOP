package oop.labor10.lab10_3;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("Battlestate games");
        company.hireAll("employees.csv");
        System.out.println("Original state:");
        company.printAll(System.out);

        System.out.println("\n\n\nSorted alphabetically:");
        company.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getLastName().compareTo(e2.getLastName());
            }
        });
        company.printAll(System.out);

        System.out.println("\n\n\nSorted by salary (descending):");
        company.sortByComparator((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        company.printAll(System.out);

        System.out.println("\n\n\nManagers first, then employees (both alphabetically):");
        company.sortByComparator((e1, e2) -> {
            boolean isManager1 = e1 instanceof Manager;
            boolean isManager2 = e2 instanceof Manager;
            if (isManager1 && !isManager2) return -1;
            if (!isManager1 && isManager2) return 1;
            return e1.getLastName().compareTo(e2.getLastName());
        });
        company.printAll(System.out);
    }
}
