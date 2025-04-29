package oop.labor09.lab9_2;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDictionary implements IDictionary {
    private ArrayList<String> words=new ArrayList<>(81027);
    private static ArrayListDictionary instance;

    private ArrayListDictionary() {

    }
    public static ArrayListDictionary newInstance() {
        if (instance == null) {
            instance = new ArrayListDictionary();
        }
        return instance;
    }

    @Override
    public boolean add(String word) {
        if (Collections.binarySearch(words, word) >= 0) {
            return false;
        }
        words.add(word);
        return true;
    }

    @Override
    public boolean find(String word) {
        if (Collections.binarySearch(words, word) >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return words.size();
    }
}
