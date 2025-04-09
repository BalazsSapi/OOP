package oop.labor07_parcialis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Document {
    private final int id;
    private String name;
    private final MyDate creationDate;
    private StringBuffer content=new StringBuffer();
    private static AtomicInteger count=new AtomicInteger();

    public Document(String name, MyDate creationDate) {
        this.name = name;
        this.creationDate = creationDate;
        id=count.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MyDate getCreationDate() {
        return creationDate;
    }

    public String getContent(){
        return content.toString();
    }

    public void addLine (String line){
        content.append(line);
        content.append("\n");
    }

    public void saveDocument(){
        File file= new File(name+".txt");
        try(FileWriter fw=new FileWriter(file)) {
            fw.append(content.toString());
        }
        catch (IOException e){
            System.out.println("Error writing to file: " + name+".txt");
            e.printStackTrace();
        }
    }

    public int getLineCount (){
        String[] strArray=content.toString().split("\n");
        return strArray.length;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", numberOfLines=" + getLineCount() +
                '}';
    }

    public boolean isEmpty(){
        return content.isEmpty();
    }

    public void addLinesFromFile(String filename){
        File file=new File(filename);
        try(Scanner scanner=new Scanner(file)) {
            while (scanner.hasNextLine()){
                String line= scanner.nextLine();
                content.append(line);
                content.append("\n");
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error opening input file!");
            e.printStackTrace();
        }
    }

    public boolean findWord(String word){
        String str=content.toString();
        return str.contains(word);
    }
}
