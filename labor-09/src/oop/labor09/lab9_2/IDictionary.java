package oop.labor09.lab9_2;

public interface IDictionary {
    public static final String DICTIONARY_FILE="english_dictionary";

    public boolean add(String word);
    public boolean find(String word);
    public int size();
}
