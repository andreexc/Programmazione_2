package Lez8_Collections;

import java.util.*;

public class GiocoRamino {

    private static final String[] VALORI = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private static final String[] SEMI = {"C", "Q", "F", "P"};

    /*
     * C = Cuori
     * Q = Quadri
     * F = Fiori
     * P = Picche
     */

    public static void Gioca() {

        // creo la mia collection
        List<String> c = new ArrayList<>();

        // ci viene chiesto due carte per tipo
        for (int count = 0; count < 2; count++) {
            // posso usare il for-each esendo array
            for(String seme : SEMI) {
                for(String valori : VALORI) {
                    c.add(seme + valori);
                }
            }
        }
        Collections.shuffle(c);   // mescolo
        // System.out.println(c); // stampo il contenuto


        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci le N carte da pescare: ");
        int N = sc.nextInt();

        if (N <= 1 || N > c.size()) {
            N = 10;
        }

        List<String> mano = new ArrayList<>();
        Iterator<String> iter = c.iterator();
        for (int i = 0; iter.hasNext() && i < N; i++) {
            mano.add(iter.next());
        }

        // la mia tecnica ottimizzata per vedere se ci sono due elementi uguali è
        // ordinare la collection e vedere gli elementi adiacenti tra loro se sono uguali
        boolean doppia = false;
        Collections.sort(mano);
        for (int i = 0; i < mano.size() - 1 && !doppia; i++) {
            if (mano.get(i).equals(mano.get(i + 1))) {
                doppia = true;
            }
        }

        if (doppia) {
            System.out.println("Hai vinto.");
        }
        else {
            System.out.println("Hai perso.");
        }
    }
}
