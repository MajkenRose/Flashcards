package com.example.flashcards;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class SerializableHelper {
    public static void skrivObjekter(ObservableList<Flashcard> flashcards) throws IOException {
       FileOutputStream fileOutputStream = new FileOutputStream("flashcards.txt");
       ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

       objectOutputStream.writeInt(flashcards.size());
       for (Flashcard f : flashcards)
           {
           objectOutputStream.writeObject(f);
           }
       System.out.println(flashcards.size());

       objectOutputStream.flush();
       objectOutputStream.close();
    }

    public static ObservableList<Flashcard> læsObjekter() throws IOException, ClassNotFoundException {
        ObservableList<Flashcard> liste = FXCollections.observableArrayList();
        FileInputStream fileInputStream = new FileInputStream("flashcards.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        System.out.println("Flashcard indlæses");
        int antal = objectInputStream.readInt();
        for (int i = 0; i < antal; i++) {
            Flashcard f = (Flashcard) objectInputStream.readObject();
            System.out.println(f);
            liste.add(f);
        }
        System.out.println("indlæses" + antal);

        objectInputStream.close();
        return (ObservableList<Flashcard>) liste;
    };
}
