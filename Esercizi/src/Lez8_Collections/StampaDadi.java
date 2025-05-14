package Lez8_Collections;

import java.util.*;

public class StampaDadi {
    public static void StampaCombinazioniDadi() {

        List<Integer> dado = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            dado.add(i);
        }

        Iterator<Integer> i = dado.iterator();
        while (i.hasNext()) {
            int faccia = i.next();

            Iterator<Integer> j = dado.iterator();
            while (j.hasNext()) {
                System.out.print(faccia);
                System.out.print("-");
                System.out.print(j.next());
                System.out.print("   ");
            }
            System.out.println();
        }
    }
}
