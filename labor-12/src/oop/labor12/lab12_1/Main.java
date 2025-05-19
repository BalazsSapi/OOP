package oop.labor12.lab12_1;

import oop.labor12.lab12_1.DictionaryService;
import oop.labor12.lab12_1.DictionaryType;
import oop.labor12.lab12_1.IDictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //HashSetDictionary class test

        //Itt lehet ki kell cserélni a fillDictionaryFromFile(String filename, IDictionary dictionary)-ban az instanceOf-ot HashSetDictionary-re
        /*IDictionary dictionary = HashSetDictionary.newInstance();
        fillDictionaryFromFile("english_dictionary", dictionary);
        System.out.println(dictionary.find("black"));
        System.out.println(dictionary.size());*/

        /*DictionaryService dictionary= new DictionaryService(DictionaryType.HASH_SET);
        fillDictionaryFromFile(IDictionary.DICTIONARY_FILE, dictionary);
        //System.out.println(dictionary.findWord("eperep"));
        ArrayList<String> wordsNotFound= new ArrayList<>();
        wordsNotFound=dictionary.findWordsFile("words_to_find");
        for(String word: wordsNotFound){
            System.out.println(word+" ");
        }*/

        //TreeSetDictionary class test

        //Itt lehet ki kell cserélni a fillDictionaryFromFile(String filename, IDictionary dictionary)-ban az instanceOf-ot TreeSetDictionary-re
        /*IDictionary dictionary = TreeSetDictionary.newInstance();
        fillDictionaryFromFile("english_dictionary", dictionary);
        System.out.println(dictionary.find("black"));
        System.out.println(dictionary.size());*/

        DictionaryService dictionary= new DictionaryService(DictionaryType.TREE_SET);
        fillDictionaryFromFile(IDictionary.DICTIONARY_FILE, dictionary);
        //System.out.println(dictionary.findWord("eperep"));
        ArrayList<String> wordsNotFound= new ArrayList<>();
        wordsNotFound=dictionary.findWordsFile("words_to_find");
        for(String word: wordsNotFound){
            System.out.println(word+" ");
        }
    }

    public static void fillDictionaryFromFile(String filename, IDictionary dictionary) {
        if (dictionary instanceof TreeSetDictionary) {
            File file = new File(filename);
            try (Scanner scanner = new Scanner(file)) {
                int line = 0;
                while (scanner.hasNextLine()) {
                    String word = scanner.nextLine();
                    dictionary.add(word);
                    //System.out.println(line++ + ": " + word);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                e.printStackTrace();
            }
        }
    }

    public static void fillDictionaryFromFile(String filename, DictionaryService dictionary) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            int line = 0;
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                dictionary.getDictionary().add(word);
                //System.out.println(line++ + ": " + word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}

