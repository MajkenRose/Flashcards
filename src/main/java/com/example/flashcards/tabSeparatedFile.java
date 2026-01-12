package com.example.flashcards;

import java.io.BufferedReader;
import java.io.FileReader;

//Her er skeletkode til at indlæse en tabsepareret fil og splitte hver record op i felter.
//Husk at felterne stadig kan indeholde gibberish.
public class tabSeparatedFile {
    public static void main(String[] args) {
        try {
            BufferedReader buf = new BufferedReader(new FileReader("GreatArtistTabSeparated.txt"));
            String læstLinje = null;
            String[] felter;  // array til oplysningerne i en linje

            // Spring de første 6 linjer over i filen - dem skal vi ikke bruge
            for (int i = 0; i < 6; i++)
                læstLinje = buf.readLine();

            // Derefter kommer data: Een linje per kunstværk
            boolean filslut = false;
            while (!filslut) {
                læstLinje = buf.readLine();
                if (læstLinje == null) {
                    filslut = true;
                } else {
                    // Læs den opdelte linje ind i arrayet felter
                    felter = læstLinje.split("\t");
                    // Nu indeholder arrayet felter[] informationen
                    // fra den læste linje. Vælg de felter du skal bruge og
                    // rens dem.
                }
            }

            buf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
