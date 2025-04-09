package oop.labor07_parcialis;

import java.util.ArrayList;

public class Repository {
    private String name;
    private ArrayList<Document> documents=new ArrayList<>();

    public Repository(String name) {
        this.name = name;
    }

    public void addDocument(Document document){
        documents.add(document);
    }

    public void deleteById(int id){
        for(Document document : documents){
            if(document.getId()==id)
            {
                documents.remove(document);
                return;
            }
        }
    }

    public Document getDocumentById(int id){
        for(Document document : documents){
            if(document.getId()==id)
            {
                return document;
            }
        }
        return null;
    }

    public void printDocumentsContainingWord(String word){
        for(Document document : documents){
            if(document.findWord(word))
            {
                System.out.println(document);
            }
        }
    }

    public boolean cronologicalOrder(){
        for(int i=0; i<documents.size()-1;i++){
            if(documents.get(i).getCreationDate().isAfter(documents.get(i+1).getCreationDate())){
                return false;
            }
        }
        return true;
    }
}
