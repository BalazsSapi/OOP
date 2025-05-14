package oop.labor12.lab12_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bac bac = new Bac();
        //System.out.println(bac);
        ArrayList<Student> notPassedBacs = bac.notPassedBacs();
        System.out.println(bac.getSizeOfStudents() + " diakbol " + (bac.getSizeOfStudents() - notPassedBacs.size()) + " diak ment at az erettsegin");
        File file = new File("nem_atmenok.txt");
        try (FileWriter fw = new FileWriter(file)){
            for (Student student : notPassedBacs) {
                fw.append(student.toString());
                fw.append("\n");
            }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("File could not be generated");
        }
    }
}
