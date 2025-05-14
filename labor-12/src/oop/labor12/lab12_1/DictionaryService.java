package oop.labor12.lab12_1;

import oop.labor12.lab12_1.DictionaryType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryService {
    private IDictionary dictionary;

    public DictionaryService(DictionaryType type) {
        dictionary=DictionaryProvider.createDictionary(type);
    }

    public boolean findWord(String word) {
        return dictionary.find(word);
    }

    public ArrayList<String> findWordsFile(String fileName) {
        ArrayList<String> wordsNotFound=new ArrayList<>();
        File file=new File(fileName);
        try(Scanner scanner=new Scanner(file)) {
            while(scanner.hasNextLine()) {
                String word=scanner.nextLine();
                if(dictionary.find(word)==false) {
                    wordsNotFound.add(word);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        return wordsNotFound;
    }

    public IDictionary getDictionary() {
        return dictionary;
    }
}
