package oop.labor05.lab5_extra;

import lab2_3.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Main {

    public static void main(String[] args) {
        List<Library> libraries = new ArrayList<>();
        List<Person> persons = new ArrayList<>();
        libraries=readLibraries("libraries.csv");
        for (Library library : libraries) {
            System.out.println(library);
        }
        //printLibraries(libraries);
        persons=readPersons("persons.csv");
        printPersons(persons);
        System.out.println("\n");
        borrowBooks(persons,libraries);

    }

    public static List<Library> readLibraries(String fileName){
        List<Library> libraries = new ArrayList<>();
        File file = new File(fileName);
        try(Scanner scanner= new Scanner(file)){
            boolean ok=true;
            String line = scanner.nextLine();
            String[] split = line.split(",");
            if(line.equals("")){
                System.out.println("No libraries found");
            }
            while (ok){
                Library library=new Library(split[2].trim(),split[1].trim());
                libraries.add(library);
                while(scanner.hasNextLine()){
                    String line2=scanner.nextLine();
                    if(line2.equals("")){
                        ok=false;
                        break;
                    }
                    String[] split2=line2.split(",");
                    if(split2[0].equals("LIBRARY")){
                        split[1]=split2[1];
                        split[2]=split2[2];
                        break;
                    }
                    else if(split2[0].equals("BOOK")){
                        libraries.get(libraries.indexOf(library)).addBook(new Book(split2[3].trim(),split2[1].trim(),split2[2].trim()));
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        return libraries;
    }
    public static void printLibraries(List<Library> libraries){
        for(Library library:libraries){
            String name=library.getName();
            String[] nameWords=name.split(" ");
            String nameOfFile="";
            for(String word:nameWords){
                nameOfFile+=word+"_";
            }
            nameOfFile+=Integer.toString(library.countBooks());
            File file=new File(nameOfFile);
            try(FileWriter fw=new FileWriter(file)){
                fw.write(library.toString());
            }
            catch (IOException e){
                System.out.println("File not found");
                e.printStackTrace();
            }
        }
    }

    public static List<Person> readPersons(String fileName){
        File file=new File(fileName);
        List<Person> persons=new ArrayList<>();
        int invalid=0;
        try(Scanner scanner=new Scanner(file)) {
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[] split=line.split(",");
                if(split.length!=5){
                    invalid++;
                    continue;
                }
                MyDate dateOfBirth=new MyDate(Integer.parseInt(split[2].trim()),Integer.parseInt(split[3].trim()),Integer.parseInt(split[4].trim()));
                if(dateOfBirth.getDay()==0 && dateOfBirth.getMonth()==0 && dateOfBirth.getYear()==0){
                    invalid++;
                    continue;
                }
                persons.add(new Person(split[0].trim(),split[1].trim(),dateOfBirth));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        System.out.println("Number of invalid lines in "+ fileName+ " = "+invalid+"\n");
        return persons;
    }

    public static void printPersons(List<Person> persons){
        for(Person person:persons){
            System.out.println(person);
        }
    }

    public static void borrowBooks(List<Person> persons, List<Library> libraries ){
        File file=new File("checkout.csv");
        int invalidNotTwoArguments=0,invalidPersonNotFound=0,invalidBookId=0,invalidBookAlreadyBorrowed=0;
        try (Scanner scanner=new Scanner(file)) {
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                String[] split=line.split(",");
                if(split.length!=2){
                    invalidNotTwoArguments++;
                    continue;
                }
                boolean ok1=false,ok2=false,ok3=false;
                for(Person person:persons){
                    if(person.getId().equals(split[0].trim())){
                        ok1=true;
                        boolean breakOut=false;
                        for(Library library: libraries){
                            if (breakOut){
                                break;
                            }
                            for(Book book:library.getBooks()){
                                if(book.getId()==Integer.parseInt(split[1].trim())){
                                    ok2=true;
                                    breakOut=true;
                                    if(book.isCheckedOut()==false){
                                        ok3=true;
                                        person.borrowBook(book);
                                        book.setCheckedOut(true);
                                    }
                                    break;
                                }
                            }

                        }
                        break;
                    }
                }
                if(ok1==false){
                    invalidPersonNotFound++;
                }
                else{
                    if(ok2==false){
                        invalidBookId++;
                    }
                    else{
                        if(ok3==false){
                            invalidBookAlreadyBorrowed++;
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        System.out.println("There where no 2 parameters in the line: "+invalidNotTwoArguments+"\n"+
                "Person ID not found: "+ invalidPersonNotFound+ "\n"+
                "Book ID not found: "+ invalidBookId+"\n"+
                "Book was already borrowed: " +invalidBookAlreadyBorrowed+"\n");
    }
}
