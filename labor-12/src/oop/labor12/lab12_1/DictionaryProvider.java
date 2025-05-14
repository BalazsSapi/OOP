package oop.labor12.lab12_1;

import oop.labor12.lab12_1.ArrayListDictionary;
import oop.labor12.lab12_1.DictionaryType;
import oop.labor12.lab12_1.IDictionary;

public class DictionaryProvider {
    public static IDictionary createDictionary(DictionaryType type) {
        IDictionary dictionary = null;
        switch (type) {
            case ARRAY_LIST:
                dictionary = ArrayListDictionary.newInstance();
                break;
            case HASH_SET :
                dictionary = HashSetDictionary.newInstance();
                break;
            case TREE_SET :
                dictionary = TreeSetDictionary.newInstance();
                break;
        }
        return dictionary;
    }
}
