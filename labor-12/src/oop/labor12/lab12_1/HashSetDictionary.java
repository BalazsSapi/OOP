package oop.labor12.lab12_1;

import java.util.Collections;
import java.util.Dictionary;
import java.util.HashSet;

public class HashSetDictionary implements IDictionary {
    private HashSet<String> words=new HashSet<>(81027);
    private static HashSetDictionary instance;

    private HashSetDictionary() {

    }

    public static HashSetDictionary newInstance() {
        if (instance == null) {
            instance = new HashSetDictionary();
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
