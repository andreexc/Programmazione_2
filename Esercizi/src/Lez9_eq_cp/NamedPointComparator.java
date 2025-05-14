package Lez9_eq_cp;

import java.util.Comparator;

public class NamedPointComparator implements Comparator<NamedPoint> {

    // ordinamento diverso da quello naturale
    public int compare(NamedPoint p1, NamedPoint p2) {
        // questo algoritmo prevede di comparare tramite l'ordinamento
        // naturale della classe string
        return p1.name.compareTo(p2.name);
    }
}
