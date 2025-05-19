package oop.labor12.lab12_1;

import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetDictionary implements IDictionary {
    private TreeSet<String> words=new TreeSet<>();
    private static TreeSetDictionary instance;

    private TreeSetDictionary() {

    }

    public static TreeSetDictionary newInstance() {
        if (instance == null) {
            instance = new TreeSetDictionary();
        }
        return instance;
    }

    @Override
    public boolean add(String word) {
        return words.add(word);
    }

    @Override
    public boolean find(String word) {
        return words.contains(word);
    }

    @Override
    public int size() {
        return words.size();
    }
}