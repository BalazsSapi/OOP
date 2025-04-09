package oop.labor07_parcialis;

public class Main {

    public static void main(String[] args) {
        MyDate date=new MyDate(2005,8,12);
        System.out.println("MyDate equals-ok meghivasa:\n" );
        System.out.println(date.equals(new MyDate(2005,8,12)));
        System.out.println(date.equals(new MyDate(2005,8,13)));
        System.out.println("\n-----------------------------------------------------------------------------------\n");

        System.out.println("MyDate isAfter-ek meghivasa:\n" );
        System.out.println(date.isAfter(new MyDate(2004,8,12)));
        System.out.println(date.isAfter(new MyDate(2006,8,12)));
        System.out.println("\n-----------------------------------------------------------------------------------\n");

        Document document=new Document("Test",new MyDate(2025,4,2));

        document.addLine("alma korte");
        document.addLine("szilve szolo");

        System.out.println("Elso dokumentum tartalmanak kiirasa:\n");
        System.out.println(document.getContent());
        System.out.println("\n-----------------------------------------------------------------------------------\n");

        document.addLine("barack narancs");
        System.out.println("Elso dokumentum tartalma kiirva a fileba:\n");
        document.saveDocument();
        System.out.println("\n-----------------------------------------------------------------------------------\n");
        System.out.println("Elso dokumentum kiirasa (toString-el):\n");
        System.out.println(document+"\n");
        System.out.println("\n-----------------------------------------------------------------------------------\n");

        Document document2=new Document("Test2",new MyDate(2025,4,2));
        document2.addLinesFromFile("parcialis.txt");

        System.out.println("Masodik dokumentum tartalmanak kiirasa:\n");
        System.out.println(document2.getContent());
        System.out.println("\n-----------------------------------------------------------------------------------\n");
        System.out.println("Masodik dokumentum kiirasa (toString-el):\n");
        System.out.println(document2);
        System.out.println("\n-----------------------------------------------------------------------------------\n");
        System.out.println("A feladat nem keri, de ellenorzom a findWord metodust:\n");
        System.out.println(document2.findWord("legkalapacs"));
        System.out.println(document2.findWord("kalapacs"));
        System.out.println("\n-----------------------------------------------------------------------------------\n");

        Repository rep=new Repository("Rep1");
        rep.addDocument(document);
        rep.addDocument(document2);
        rep.addDocument(new Document("Ures",new MyDate(2025,4,3)));
        System.out.println("A feladat nem keri, de kiiratom a harmadik (ures) elemet a repository-bol:\n");
        System.out.println(rep.getDocumentById(3));
        System.out.println("\n-----------------------------------------------------------------------------------\n");
        System.out.println("Ellenorzom, hogy ures-e a harmadik elem a repository-ban:\n");
        System.out.println(rep.getDocumentById(3).isEmpty());
        System.out.println("\n-----------------------------------------------------------------------------------\n");
        rep.deleteById(3);
        System.out.println("Kiiratom a kalapacs szot tartalmazo documentumokat:\n");
        rep.printDocumentsContainingWord("kalapacs");
    }
}